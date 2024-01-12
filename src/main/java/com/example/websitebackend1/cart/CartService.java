package com.example.websitebackend1.cart;

import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public List<Cart> GetAccountCart(String stringSessionToken) {
        UUID sessionToken = UUID.fromString(stringSessionToken);
        RestTemplate restTemplate = new RestTemplate();
        String sessionAccountUrl = "http://127.0.0.1:8080/api/v1/session/account";
        UUID accountUuid = restTemplate.postForObject(sessionAccountUrl, sessionToken, UUID.class);

        return cartRepository.getAllCartItemsFromAccount(accountUuid);
    }

    @Transactional
    public void AddToCart(Cart cart) {


        UUID sessiontoken = cart.getAccountUuid();

        RestTemplate restTemplate = new RestTemplate();
        String sessionAccountUrl = "http://127.0.0.1:8080/api/v1/session/account";
        UUID accountUuid = restTemplate.postForObject(sessionAccountUrl, sessiontoken, UUID.class);

        if (accountUuid == null){
            throw new IllegalStateException("Cart isn't available");
        }

        UUID product = cart.getProductUuid();
        //check if product exists
//        RestTemplate restTemplate2 = new RestTemplate();
//        String productUrl = "http://127.0.0.1:8080/api/v1/product";
//        Product productInShop = restTemplate2.postForObject(productUrl, product, Product.class);
        //Else override with new amount


        String amount = cart.getAmount();

        Cart newCart = new Cart(accountUuid, product, amount);
        System.out.println(newCart);


        cartRepository.save(newCart);
    }

    public void DeleteFromCart(String stringProductUuid) {
        UUID productUuid = UUID.fromString(stringProductUuid);
        Long productId = cartRepository.findIdByProductUuid(productUuid);
        cartRepository.deleteById(productId);
    }

    @Transactional
    public void UpdateCartAmount(UUID sessionUuid, UUID productUuid, String stringAmount) {

        int amount = Integer.parseInt(stringAmount);

        RestTemplate restTemplate = new RestTemplate();
        String sessionAccountUrl = "http://127.0.0.1:8080/api/v1/session/account";
        UUID accountUuid = restTemplate.postForObject(sessionAccountUrl, sessionUuid, UUID.class);

        Optional<Cart> cartOptional = cartRepository.findCartByProduct(accountUuid, productUuid);

        if (cartOptional.isPresent()){
//            Cart cart = cartOptional.get();

            if (amount == 0){
                cartRepository.deleteById(cartOptional.get().getId());
            } else {
                cartRepository.deleteById(cartOptional.get().getId());
                cartRepository.save(new Cart(accountUuid, productUuid, stringAmount));

            }
        } else {
            throw new IllegalStateException("Cart does not exist");
        }

    }
}
