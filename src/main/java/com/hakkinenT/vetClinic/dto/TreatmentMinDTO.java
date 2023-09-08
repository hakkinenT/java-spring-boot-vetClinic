package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.entities.Treatment;

import java.time.LocalDate;

public class TreatmentMinDTO {
    private Long id;
    private LocalDate initialDate;
    private LocalDate finalDate;

    public TreatmentMinDTO(Long id, LocalDate initialDate, LocalDate finalDate) {
        this.id = id;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }

    public TreatmentMinDTO(Treatment entity) {
        id = entity.getId();
        initialDate = entity.getInitialDate();
        finalDate = entity.getFinalDate();
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
}
