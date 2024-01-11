package com.example.websitebackend1.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    public void addNewSession(Session session){
        sessionRepository.save(session);
    }
}
