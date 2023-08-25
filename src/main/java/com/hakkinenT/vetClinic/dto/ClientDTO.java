package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.dto.validators.phone.Phone;
import com.hakkinenT.vetClinic.entities.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClientDTO {
    private Long id;

    @NotBlank(message = "O campo Nome é obrigatório.")
    @Size(min = 3, message = "O nome precisa ter mais de 3 caracteres.")
    private String name;

    @Email(message = "Informe um e-mail válido.")
    private String email;

    @NotBlank(message = "O campo Nome é obrigatório.")
    @Phone
    private String phone;

    @Valid
    @NotNull(message = "O campo Endereço é obrigatório.")
    private AddressDTO address;

    public ClientDTO(Long id, String name, String email, String phone,AddressDTO address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public ClientDTO(Client client) {
        id = client.getId();
        name = client.getName();
        email = client.getEmail();
        phone = client.getPhone();
        address = new AddressDTO(client.getAddress());
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

    public AddressDTO getAddress() {
        return address;
    }
}
