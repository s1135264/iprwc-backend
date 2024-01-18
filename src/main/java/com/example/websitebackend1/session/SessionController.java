package com.example.websitebackend1.session;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "http://188.166.118.19")
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

    @PostMapping(path = "/role")
    public String isSeller(@RequestBody ObjectNode json){
        UUID sessionUuid = UUID.fromString(json.get("sessionUuid").asText());
        String ifSeller = null;
//        String isSeller = sessionService.getIfSeller(sessionUuid);
        ifSeller = sessionService.getIfSeller(sessionUuid);
        return ifSeller;
    }

    @PostMapping(path = "/validate")
    public boolean validate(@RequestBody UUID sessionUuid){
        return sessionService.validate(sessionUuid);
    }
}
