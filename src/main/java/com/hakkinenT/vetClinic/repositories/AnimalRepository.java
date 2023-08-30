package com.hakkinenT.vetClinic.repositories;

import com.hakkinenT.vetClinic.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
