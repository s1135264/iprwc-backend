package com.example.websitebackend1.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/logout")
    public void logout(@RequestBody String sessionUuid){
        accountService.logout(sessionUuid);
    }

    @PostMapping(path = "/create")
    public void registerNewAccount(@RequestBody Account account) {
        accountService.addNewAccount(account);
    }

    @PostMapping(path = "/role")
    public String getRole(@RequestBody String accountUuid){
        return accountService.GetRole(accountUuid);
    }

    @PostMapping(path = "/validate")
    public boolean validate(@RequestBody String sessionUuid){
        return accountService.validate(sessionUuid);
    }
}
