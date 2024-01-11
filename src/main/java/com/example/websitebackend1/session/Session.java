package com.example.websitebackend1.session;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Session {
    @Id
    @SequenceGenerator(
            name = "session_sequence",
            sequenceName = "session_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "session_sequence"
    )
    private long id;
    private String creationDate;
    private String LastUseDate;
    private UUID userUuid;
    private UUID token;

    public Session(){
    }


    public Session(long id, String creationDate, String lastUseDate, UUID userUuid, UUID token) {
        this.id = id;
        this.creationDate = creationDate;
        LastUseDate = lastUseDate;
        this.userUuid = userUuid;
        this.token = token;
    }

    public Session(String creationDate, UUID userUuid) {
        this.creationDate = creationDate;
        this.userUuid = userUuid;
    }

    public Session(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public Session(String creationDate, String lastUseDate, UUID userUuid) {
        this.creationDate = creationDate;
        LastUseDate = lastUseDate;
        this.userUuid = userUuid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUseDate() {
        return LastUseDate;
    }

    public void setLastUseDate(String lastUseDate) {
        LastUseDate = lastUseDate;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", LastUseDate='" + LastUseDate + '\'' +
                ", userUuid=" + userUuid +
                ", token=" + token +
                '}';
    }
}
