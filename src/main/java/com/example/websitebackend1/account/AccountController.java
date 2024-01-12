package com.example.websitebackend1.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.UUID;

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
    public UUID Login(@RequestBody Account account){
        return accountService.login(account);
    }

    @DeleteMapping()
    public void deleteAccount(@RequestBody UUID sessionUuid){
        accountService.deleteAccount(sessionUuid);
    }

    @PostMapping(path = "/create")
    public void registerNewAccount(@RequestBody Account account) {
        accountService.addNewAccount(account);
    }
}
