package com.example.websitebackend1.cart;

import jakarta.persistence.*;

import java.util.UUID;

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
    private UUID accountUuid;
    private UUID productUuid;
    private String amount;
    private UUID token = UUID.randomUUID();

    public Cart(long id, UUID accountUuid, UUID productUuid, String amount, UUID token) {
        this.id = id;
        this.accountUuid = accountUuid;
        this.productUuid = productUuid;
        this.amount = amount;
        this.token = token;
    }

    public Cart(UUID accountUuid, UUID productUuid, String amount) {
        this.accountUuid = accountUuid;
        this.productUuid = productUuid;
        this.amount = amount;
    }

    public Cart(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(UUID accountUuid) {
        this.accountUuid = accountUuid;
    }

    public UUID getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(UUID productId) {
        this.productUuid = productId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productUuid=" + productUuid +
                ", amount='" + amount + '\'' +
                '}';
    }
}
