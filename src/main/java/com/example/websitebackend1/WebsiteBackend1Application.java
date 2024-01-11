package com.example.websitebackend1;

import com.example.websitebackend1.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class WebsiteBackend1Application {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteBackend1Application.class, args);
    }

}
