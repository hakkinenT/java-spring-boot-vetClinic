package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.entities.Treatment;

import java.time.LocalDate;

public class TreatmentDTO {
    private Long id;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private AnimalMinDTO animal;

    public TreatmentDTO(Long id, LocalDate initialDate, LocalDate finalDate, AnimalMinDTO animal) {
        this.id = id;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.animal = animal;
    }

    public TreatmentDTO(Treatment entity) {
        id = entity.getId();
        initialDate = entity.getInitialDate();
        finalDate = entity.getFinalDate();
        animal = new AnimalMinDTO(entity.getAnimal());
    }

    public Long getId() {
        return id;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public AnimalMinDTO getAnimal() {
        return animal;
    }
}
