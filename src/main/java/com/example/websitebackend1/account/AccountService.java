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

//    public String login(String username, String password) {
//        String userId = accountRepository.getIdByUsernameAndPassword(username, password);
//        System.out.println("user Id is: " + userId);
//        if (userId == null){
//            return null;
//        } else {
////            return userId;
//            return getToken(userId);
//        }
//    }

//    private String getToken(String userId) {
//
//        //if token exists. Give that one. Else generate a new one
//        if (userTokenService.getToken(userId) != null){
//            return userTokenService.getToken(userId);
//        } else {
//            String token = generateToken();
//            userTokenService.addNewUserToken(new UserToken(userId, token));
//            return token;
//        }
//    }
}
