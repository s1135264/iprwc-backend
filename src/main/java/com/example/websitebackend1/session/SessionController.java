package com.example.websitebackend1.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/v1/session")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @PostMapping
    public UUID addNewSession(@RequestBody UUID userUuid){
        Session session = new Session(userUuid);
        UUID sessionToken = sessionService.addNewSession(session);

        return sessionToken;
    }

    @PostMapping(path = "/delete")
    public void deleteSession(@RequestBody UUID sessionUuid){
        sessionService.deleteSession(sessionUuid);
    }

    @PostMapping(path = "/account")
    public UUID getAccount(@RequestBody UUID sessionUuid){
        UUID userUuid = sessionService.getAccount(sessionUuid);
        return userUuid;
    }
}
