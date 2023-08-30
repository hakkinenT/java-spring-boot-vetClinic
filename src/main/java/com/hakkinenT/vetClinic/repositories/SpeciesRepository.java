package com.hakkinenT.vetClinic.repositories;

import com.hakkinenT.vetClinic.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Long> {
}
