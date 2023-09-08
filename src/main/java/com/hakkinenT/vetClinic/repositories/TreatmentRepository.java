package com.hakkinenT.vetClinic.repositories;

import com.hakkinenT.vetClinic.entities.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    @Query("SELECT t FROM Treatment t WHERE t.animal.id = :animalId AND t.initialDate = :initialDate")
    Optional<Treatment> searchIfExists(Long animalId, LocalDate initialDate);
}
