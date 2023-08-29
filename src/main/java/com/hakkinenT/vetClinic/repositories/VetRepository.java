package com.hakkinenT.vetClinic.repositories;

import com.hakkinenT.vetClinic.entities.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
