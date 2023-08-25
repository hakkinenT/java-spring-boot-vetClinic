package com.hakkinenT.vetClinic.repositories;

import com.hakkinenT.vetClinic.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
