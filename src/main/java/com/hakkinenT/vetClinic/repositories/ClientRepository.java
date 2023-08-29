package com.hakkinenT.vetClinic.repositories;

import com.hakkinenT.vetClinic.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByNameContainingIgnoreCase(String name);
}
