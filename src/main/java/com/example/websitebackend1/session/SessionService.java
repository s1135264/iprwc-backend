package com.example.websitebackend1.session;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    @Transactional
    public UUID addNewSession(Session session){
        //check if session already exists
        Optional<Session> sessionOptional = sessionRepository.findSessionByUserUuid(session.getUserUuid());

        //check if session exists
        if (sessionOptional.isPresent()){
            LocalDate oldSessionDate = sessionOptional.get().getLastUseDate();
            LocalDate currentDate = session.getLastUseDate();
            //check if session is 2 days old
            if (oldSessionDate.isBefore(currentDate.minusDays(2))){
                System.out.println("session expired");
                //Delete old session
                sessionRepository.delete(sessionOptional.get());

                //generate new session
                sessionRepository.save(session);
                return session.getToken();

            } else {
                System.out.println("session refreshed");
                //update token last used date
                sessionOptional.get().setLastUseDate(session.getLastUseDate());

                return sessionOptional.get().getToken();

            }

        } else {
            //generate session
            sessionRepository.save(session);
            return session.getToken();
        }
    }

    public void deleteSession(UUID sessionUuid) {
        Session currentSession = sessionRepository.findSessionByToken(sessionUuid);
        if (currentSession == null){
            throw new IllegalStateException("Session with token " + sessionUuid + " does not exist");
        } else {
            sessionRepository.delete(currentSession);
        }
    }

    public UUID getAccount(UUID sessionUuid) {
        Session currentSession = sessionRepository.findSessionByToken(sessionUuid);
        if (currentSession == null){
            throw new IllegalStateException("Session with token " + sessionUuid + " does not exist");
        } else {
            return currentSession.getUserUuid();
        }
    }

    public String getIfSeller(UUID sessionUuid) {
        //get user uuid from session
        UUID userUuid = getAccount(sessionUuid);

        //get role from Account
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/api/v1/account/role";
        String role = restTemplate.postForObject(url, userUuid, String.class);


        return role;
    }
}
