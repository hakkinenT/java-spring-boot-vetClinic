package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.dto.validators.zipCode.ZipCode;
import com.hakkinenT.vetClinic.entities.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddressDTO {
    private Long id;

    @NotBlank(message = "O campo Rua é obrigatório.")
    private String street;

    @NotBlank(message = "O campo Número é obrigatório.")
    private String number;

    @NotBlank(message = "O campo Bairro é obrigatório.")
    private String neighborhood;

    @NotBlank(message = "O campo Cidade é obrigatório.")
    private String city;

    @NotBlank(message = "O campo Estado é obrigatório.")
    private String state;

    @NotBlank(message = "O campo CEP é obrigatório.")
    @ZipCode
    private String zipCode;

    public AddressDTO(Long id, String street, String number, String neighborhood, String city, String state, String zipCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public AddressDTO(Address entity) {
        id = entity.getId();
        street = entity.getStreet();
        number = entity.getNumber();
        neighborhood = entity.getNeighborhood();
        city = entity.getCity();
        state = entity.getState();
        zipCode = entity.getZipCode();
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }
}
