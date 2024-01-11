package com.example.websitebackend1.account;

import com.example.websitebackend1.userToken.UserToken;
import com.example.websitebackend1.userToken.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public String login(Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
        String userId = accountRepository.getIdByUsernameAndPassword(username, password);
        System.out.println("user Id is: " + userId);
        if (userId == null){
            throw new IllegalStateException("Username and password combination does not exist");
        } else {
            //check if user already has a token
            //check if token is expired
            //if expired, generate new token
            //if not expired, return token
            return userId;
        }
    }


}
