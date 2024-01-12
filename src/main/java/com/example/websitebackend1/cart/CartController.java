package com.example.websitebackend1.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/v1/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(path = "/get")
    public List<String> GetCart(@RequestBody UUID sessionToken) {
        return cartService.GetAccountCart(sessionToken);
    }

    @PostMapping
    public void AddToCart(@RequestBody Cart cart) {
        cartService.AddToCart(cart);
    }

    @DeleteMapping
    public void DeleteFromCart(@RequestBody UUID productUuid) {
        cartService.DeleteFromCart(productUuid);
    }

}