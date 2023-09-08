package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.dto.validators.phone.Phone;
import com.hakkinenT.vetClinic.entities.Vet;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VetMinDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;


    public VetMinDTO(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public VetMinDTO(Vet vet) {
        id = vet.getId();
        name = vet.getName();
        email = vet.getEmail();
        phone = vet.getPhone();

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


}
