package com.example.websitebackend1.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping
    public void registerNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productID}")
    public void deleteProduct(@PathVariable("productID") Long productID){
        productService.deleteProduct(productID);
    }

    @PutMapping(path = "{productID}")
    public void updateProduct(
            @PathVariable("productID") Long productID,
            @RequestParam(required = false) String productQuantity,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) String productImageURL,
            @RequestParam(required = false) String productDescription,
            @RequestParam(required = false) String productPrice){
        productService.updateProduct(productID, productQuantity, productName, productImageURL, productDescription, productPrice);
    }

}
