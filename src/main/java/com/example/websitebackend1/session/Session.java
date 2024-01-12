package com.example.websitebackend1.session;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
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
    private LocalDate creationDate = LocalDate.now();
    private LocalDate LastUseDate = LocalDate.now();
    private UUID userUuid;
    private UUID token = UUID.randomUUID();

    public Session(long id, LocalDate creationDate, LocalDate lastUseDate, UUID userUuid, UUID token) {
        this.id = id;
        this.creationDate = creationDate;
        LastUseDate = lastUseDate;
        this.userUuid = userUuid;
        this.token = token;
    }

    public Session(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public Session() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getLastUseDate() {
        return LastUseDate;
    }

    public void setLastUseDate(LocalDate lastUseDate) {
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
