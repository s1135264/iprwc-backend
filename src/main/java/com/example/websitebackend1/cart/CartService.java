package com.example.websitebackend1.cart;

import com.example.websitebackend1.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public List<String> GetAccountCart(UUID sessionToken) {
        RestTemplate restTemplate = new RestTemplate();
        String sessionAccountUrl = "http://127.0.0.1:8080/api/v1/session/account";
        UUID accountUuid = restTemplate.postForObject(sessionAccountUrl, sessionToken, UUID.class);
        return cartRepository.getAllCartItemsFromAccount(accountUuid);
    }

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

    public void DeleteFromCart(UUID productUuid) {
        Long productId = cartRepository.findIdByProductUuid(productUuid);
        cartRepository.deleteById(productId);
    }
}
