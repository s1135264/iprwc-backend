package com.example.websitebackend1.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query("SELECT s FROM Session s WHERE s.userUuid = ?1")
    Optional<Session> findSessionByUserUuid(UUID userUuid);

    @Query("SELECT s FROM Session s WHERE s.token = ?1")
    Session findSessionByToken(UUID sessionUuid);
}
