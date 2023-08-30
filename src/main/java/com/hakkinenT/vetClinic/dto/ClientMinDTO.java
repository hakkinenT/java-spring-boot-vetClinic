package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.entities.Client;


public class ClientMinDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public ClientMinDTO(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public ClientMinDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        phone = entity.getPhone();
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
