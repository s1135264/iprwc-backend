package com.example.websitebackend1.userToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/v1/userToken")
public class UserTokenController {

    private final UserTokenService userTokenService;

    @Autowired
    public UserTokenController(UserTokenService userTokenService){
        this.userTokenService = userTokenService;
    }
}
