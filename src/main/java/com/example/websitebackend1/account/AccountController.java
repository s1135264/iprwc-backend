package com.example.websitebackend1.account;

import com.example.websitebackend1.userToken.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

//    @GetMapping(path = "/login/{username}/{password}")
//    public String Login(@PathVariable("username") String username, @PathVariable("password") String password){
//        return accountService.login(username, password);
//    }

    @PostMapping(path = "/create")
    public void registerNewAccount(@RequestBody Account account) {
        accountService.addNewAccount(account);
    }
}
