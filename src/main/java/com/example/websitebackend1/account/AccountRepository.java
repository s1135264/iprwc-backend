package com.example.websitebackend1.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.username = ?1 AND a.password = ?2")
    Account getAccount(String username, String password);

    @Query("SELECT a.token FROM Account a WHERE a.username = ?1 AND a.password = ?2")
    String getUuidByUsernameAndPassword(String username, String password);

    @Query("SELECT a FROM Account a WHERE a.username = ?1")
    Optional<Account> findAccountByUsername(String username);
}
