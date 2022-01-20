package com.aplication.project.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT s FROM Client s WHERE s.email =?1")
    Optional<Client> findClientByEmail(String email);
}
