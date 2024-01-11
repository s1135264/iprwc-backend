package com.example.websitebackend1.userToken;

import com.example.websitebackend1.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserTokenConfig {

    @Bean
    CommandLineRunner commandLineRunnerUserToken(ProductRepository repository){
        return args -> {

//            repository.save();
        };
    }
}
