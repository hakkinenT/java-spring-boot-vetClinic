package com.hakkinenT.vetClinic.repositories;

import com.hakkinenT.vetClinic.dto.AnimalDTO;
import com.hakkinenT.vetClinic.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Query("SELECT new com.hakkinenT.vetClinic.dto.AnimalDTO(animal) "
    + "FROM Animal animal "
    + "JOIN FETCH animal.client "
    + "JOIN FETCH animal.species "
    + "JOIN FETCH animal.client.address "
    + "WHERE UPPER(animal.client.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    List<AnimalDTO> searchAllAnimalByClientName(String name);

    @Modifying
    @Query("DELETE FROM Animal animal WHERE animal.client.id = :clientId")
    void deleteAllAnimalsByClientId(Long clientId);
}
