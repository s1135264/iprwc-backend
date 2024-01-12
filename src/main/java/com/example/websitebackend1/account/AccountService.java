package com.example.websitebackend1.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public void addNewAccount(Account account) {
        Optional<Account> accountOptional = accountRepository.findAccountByUsername(account.getUsername());
        if (accountOptional.isPresent()){
            throw new IllegalStateException("Username taken");
        }
        accountRepository.save(account);
    }

    public UUID login(Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
        UUID userUuid = UUID.fromString(accountRepository.getUuidByUsernameAndPassword(username, password));
        System.out.println("user Id is: " + userUuid);
        if (userUuid == null){
            throw new IllegalStateException("Username and password combination does not exist");
        } else {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://127.0.0.1:8080/api/v1/session";
            UUID sessionToken = restTemplate.postForObject(url, userUuid, UUID.class);

            return sessionToken;
        }
    }


    public void logout(String StringsessionUuid) {
        UUID sessionUuid = UUID.fromString(StringsessionUuid);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/api/v1/session/delete";
        restTemplate.postForObject(url, sessionUuid, UUID.class);
    }

    public String GetRole(String stringAccountUuid) {
        UUID accountUuid = UUID.fromString(stringAccountUuid);
        String role = accountRepository.getRoleByUuid(accountUuid);
        return role;
    }
}
