package com.example.websitebackend1.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> GetProducts(){
        return productRepository.findAll();
    }

//    public void addNewProduct(UUID sessionUuid, Product product) {
//
//        //check if session is seller trough http request
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://127.0.0.1:8080/api/v1/session/role";
//        String isSeller = restTemplate.postForObject(url, sessionUuid, String.class);
//
//        if (isSeller == null){
//            throw new IllegalStateException("You are not a seller");
//        }
//
//        //if not throw exception
//        //if yes continue
//
//        Optional<Product> productOptional = productRepository.findProductByProductName(product.getProductName());
//        if(productOptional.isPresent()){
//            throw new IllegalStateException("Product name was taken");
//        }
//        productRepository.save(product);
////        System.out.println(product);
//    }

    public void deleteProduct(Long productID) {
        boolean exists = productRepository.existsById(productID);
        if (!exists){
            throw new IllegalStateException("Product with id " + productID + " does not exists");
        }
        productRepository.deleteById(productID);
    }

    @Transactional
    public void updateProduct(Long productID, String productQuantity, String productName, String productImageURL, String productDescription, String productPrice) {
        Product product = productRepository.findById(productID).orElseThrow(() -> new IllegalStateException("Product with id " + productID + " does not exist."));

        if (productQuantity != null &&
                productQuantity.length() > 0 &&
                !Objects.equals(product.getProductQuantity(), productQuantity)){
            product.setProductQuantity(productQuantity);
        }

        if (productName != null &&
                productName.length() > 0 &&
                !Objects.equals(product.getProductName(), productName)
        ){
            Optional<Product> productOptional = productRepository.findProductByProductName(productName);
            if (productOptional.isPresent()){
                throw new IllegalStateException("Name taken");
            }
            product.setProductName(productName);
        }

        if (productImageURL != null &&
                productImageURL.length() > 0 &&
                !Objects.equals(product.getProductImageURL(), productImageURL)
        ){
            product.setProductImageURL(productImageURL);
        }

        if (productDescription != null &&
                productDescription.length() > 0 &&
                !Objects.equals(product.getProductDescription(), productDescription)
        ){
            product.setProductDescription(productDescription);
        }

        if (productPrice != null &&
                productPrice.length() > 0 &&
                !Objects.equals(product.getProductPrice(), productPrice)
        ){
            product.setProductPrice(productPrice);
        }

    }

    public List<Product> GetProductsByFilter(String filter) {
        filter = filter.toLowerCase();
        return productRepository.findProductsByProductNameContaining(filter);
    }

    public List<Product> GetProductByUuid(String stringProductUuid) {
        UUID productUuid = UUID.fromString(stringProductUuid);
        return productRepository.findProductByProductUuid(productUuid);
    }
}
