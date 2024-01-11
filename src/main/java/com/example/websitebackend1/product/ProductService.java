package com.example.websitebackend1.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addNewProduct(Product product) {

        Optional<Product> productOptional = productRepository.findProductByProductName(product.getProductName());
        if(productOptional.isPresent()){
            throw new IllegalStateException("Product name was taken");
        }
        productRepository.save(product);
//        System.out.println(product);
    }

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
}
