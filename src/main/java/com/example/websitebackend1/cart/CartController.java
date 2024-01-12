package com.example.websitebackend1.cart;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public List<Cart> GetCart(@RequestBody String sessionToken) {
        return cartService.GetAccountCart(sessionToken);
    }

    @PostMapping
    public void AddToCart(@RequestBody Cart cart) {
        cartService.AddToCart(cart);
    }

    @PostMapping(path = "/remove")
    public void DeleteFromCart(@RequestBody String productUuid, String sessionToken) {
        cartService.DeleteFromCart(productUuid, sessionToken);
    }

    @PatchMapping()
    public void UpdateCart(@RequestBody ObjectNode json) {
        UUID sessionUuid = UUID.fromString(json.get("sessionUuid").asText());
        UUID productUuid = UUID.fromString(json.get("productUuid").asText());
        String amount = json.get("amount").asText();
//        System.out.println("sessionUuid: " + sessionUuid + " productUuid: " + productUuid + " amount: " + amount);
        cartService.UpdateCartAmount(sessionUuid, productUuid, amount);

//        cartService.UpdateCartAmount(sessionUuid, productUuid, amount);
    }

}