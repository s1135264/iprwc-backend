package com.example.websitebackend1.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping(path = "/login")
    public String Login(@RequestBody Account account){
        return accountService.login(account);
    }

    @PostMapping(path = "/create")
    public void registerNewAccount(@RequestBody Account account) {
        accountService.addNewAccount(account);
    }
}
