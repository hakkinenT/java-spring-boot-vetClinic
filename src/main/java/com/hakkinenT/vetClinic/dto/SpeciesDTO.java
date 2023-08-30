package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.entities.Species;

public class SpeciesDTO {
    private Long id;
    private String name;

    public SpeciesDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SpeciesDTO(Species entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
