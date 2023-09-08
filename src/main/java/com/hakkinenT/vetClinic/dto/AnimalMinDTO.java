package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.entities.Animal;

public class AnimalMinDTO {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private SpeciesDTO species;


    public AnimalMinDTO(Long id, String name, Integer age, String gender, SpeciesDTO species) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.species = species;
    }

    public AnimalMinDTO(Animal entity) {
        id = entity.getId();
        name = entity.getName();
        age = entity.getAge();
        gender = entity.getGender().name();
        species = new SpeciesDTO(entity.getSpecies());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public SpeciesDTO getSpecies() {
        return species;
    }
}
