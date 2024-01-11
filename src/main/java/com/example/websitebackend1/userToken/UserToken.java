package com.example.websitebackend1.userToken;

import jakarta.persistence.*;

@Entity
@Table
public class UserToken {
    @Id
    @SequenceGenerator(
            name = "userToken_sequence",
            sequenceName = "userToken_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userToken_sequence"
    )
    private long id;
    private String creationDate;
    private String LastUseDate;
    private String userId;

    public UserToken(){
    }



    public UserToken(long id,
                     String creationDate,
                     String lastUseDate,
                     String userId) {
        this.id = id;
        this.creationDate = creationDate;
        LastUseDate = lastUseDate;
        this.userId = userId;
    }

    public UserToken(String creationDate, String userId) {
        this.creationDate = creationDate;
        this.userId = userId;
    }

    public UserToken(String userId) {
        this.userId = userId;
    }

    public UserToken(String creationDate, String lastUseDate, String userId) {
        this.creationDate = creationDate;
        LastUseDate = lastUseDate;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", LastUseDate='" + LastUseDate + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
