package com.example.websitebackend1.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunnerAccount(AccountRepository repository){
        return args -> {
            Account Admin = new Account(
                    1,
                    "true",
                    "Felix",
                    "TheGreat",
                    "example@email.com",
                    "0800-0113",
                    "01-1-2000",
                    "NotAdmin306",
                    "DefNotAdmin17"
            );

            repository.saveAll(
                    List.of(Admin)
            );
        };
    }
}
