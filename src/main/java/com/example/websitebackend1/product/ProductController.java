package com.example.websitebackend1.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://188.166.118.19")
@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> GetProducts(){
        return productService.GetProducts();
    }

    @GetMapping(path = "{filter}")
    public List<Product> GetProductsByFilter(@PathVariable("filter") String filter){
        return productService.GetProductsByFilter(filter);
    }

    @PostMapping(path = "uuid")
    public List<Product> GetProductByUuid(@RequestBody String stringProductUuid){
        return productService.GetProductByUuid(stringProductUuid);
    }

//    @PostMapping
//    public void registerNewProduct(@RequestBody UUID sessionUuid, Product product) {
//        productService.addNewProduct(sessionUuid, product);
//    }

//    @DeleteMapping(path = "{productID}")
//    public void deleteProduct(@PathVariable("productID") Long productID){
//        productService.deleteProduct(productID);
//    }

//    @PutMapping(path = "{productID}")
//    public void updateProduct(
//            @PathVariable("productID") Long productID,
//            @RequestParam(required = false) String productQuantity,
//            @RequestParam(required = false) String productName,
//            @RequestParam(required = false) String productImageURL,
//            @RequestParam(required = false) String productDescription,
//            @RequestParam(required = false) String productPrice){
//        productService.updateProduct(productID, productQuantity, productName, productImageURL, productDescription, productPrice);
//    }

}
