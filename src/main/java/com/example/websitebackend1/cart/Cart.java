package com.example.websitebackend1.cart;

import jakarta.persistence.*;

@Entity
@Table
public class Cart {
    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    private long id;
    private String AccountId;
    private String productId;
    private String amount;

    public Cart(){
    }

    public Cart(long id, String accountId, String productId, String amount) {
        this.id = id;
        AccountId = accountId;
        this.productId = productId;
        this.amount = amount;
    }

    public Cart(String accountId, String productId, String amount) {
        AccountId = accountId;
        this.productId = productId;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", AccountId='" + AccountId + '\'' +
                ", productId='" + productId + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
