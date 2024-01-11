package com.example.websitebackend1.product;

import jakarta.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long productID;
    private String productName;
    private String productPrice;
    private String productImageURL;
    private String productDescription;
    private String productQuantity;

    public Product() {
    }

    public Product(Long productID,
                   String productName,
                   String productPrice,
                   String productImageURL,
                   String productDescription,
                   String productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImageURL = productImageURL;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
    }

    public Product(String productName,
                   String productPrice,
                   String productImageURL,
                   String productDescription,
                   String productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImageURL = productImageURL;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
    }


    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productImageURL='" + productImageURL + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
