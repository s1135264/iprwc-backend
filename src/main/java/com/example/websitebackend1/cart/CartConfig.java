package com.example.websitebackend1.cart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartConfig {

    @Bean
    CommandLineRunner commandLineRunnerCart(CartRepository repository){
        return args -> {
//            repository.save();
        };
    }
}
