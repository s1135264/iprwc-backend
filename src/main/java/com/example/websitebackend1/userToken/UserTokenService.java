package com.example.websitebackend1.userToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenService {

    private final UserTokenRepository userTokenRepository;

    @Autowired
    public UserTokenService(UserTokenRepository userTokenRepository){
        this.userTokenRepository = userTokenRepository;
    }

    public void addNewUserToken(UserToken userToken){
        userTokenRepository.save(userToken);
    }
}
