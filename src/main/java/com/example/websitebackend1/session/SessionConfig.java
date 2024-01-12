package com.example.websitebackend1.session;

import com.example.websitebackend1.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionConfig {

    @Bean
    CommandLineRunner commandLineRunnerSession(ProductRepository repository){
        return args -> {

//            repository.save();
        };
    }
}
