package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.entities.Animal;

public class AnimalDTO {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private SpeciesDTO species;
    private ClientMinDTO client;

    public AnimalDTO(Long id, String name, Integer age, String gender, SpeciesDTO species, ClientMinDTO client) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.species = species;
        this.client = client;
    }

    public AnimalDTO(Animal entity) {
        id = entity.getId();
        name = entity.getName();
        age = entity.getAge();
        gender = entity.getGender().name();
        species = new SpeciesDTO(entity.getSpecies());
        client = new ClientMinDTO(entity.getClient());
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

    public ClientMinDTO getClient() {
        return client;
    }
}
