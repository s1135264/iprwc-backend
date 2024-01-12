package com.example.websitebackend1.account;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private long id;
    private String seller;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String StringOfBirth;
    private String username;
    private String password;
    private UUID token = UUID.randomUUID();

    public Account(){
    }


    //Everything constructor
    public Account(long id,
                   String seller,
                   String firstName,
                   String lastName,
                   String email,
                   String phoneNumber,
                   String StringOfBirth,
                   String username,
                   String password) {
        this.id = id;
        this.seller = seller;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.StringOfBirth = StringOfBirth;
        this.username = username;
        this.password = password;
    }

    //minimal buyer constructor
    public Account(String username,
                   String password) {
        this.username = username;
        this.password = password;
    }

    //Account creation constructor
    public Account(String firstName,
                   String lastName,
                   String email,
                   String phoneNumber,
                   String StringOfBirth,
                   String username,
                   String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.StringOfBirth = StringOfBirth;
        this.username = username;
        this.password = password;
    }

    //Default seller constructor
    public Account(String seller,
                   String firstName,
                   String lastName,
                   String email,
                   String phoneNumber,
                   String StringOfBirth,
                   String username,
                   String password) {
        this.seller = seller;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.StringOfBirth = StringOfBirth;
        this.username = username;
        this.password = password;
    }

    //minimal seller constructor
    public Account(String seller,
                   String username,
                   String password) {
        this.seller = seller;
        this.username = username;
        this.password = password;
    }


    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStringOfBirth() {
        return StringOfBirth;
    }

    public void setStringOfBirth(String StringOfBirth) {
        this.StringOfBirth = StringOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    //toString
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", seller='" + seller + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", StringOfBirth='" + StringOfBirth + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token=" + token +
                '}';
    }
}

