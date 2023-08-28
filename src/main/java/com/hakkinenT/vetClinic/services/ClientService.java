package com.hakkinenT.vetClinic.services;

import com.hakkinenT.vetClinic.dto.ClientDTO;
import com.hakkinenT.vetClinic.entities.Address;
import com.hakkinenT.vetClinic.entities.Client;
import com.hakkinenT.vetClinic.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();
        copyEntityToDto(dto, client, null);

        client = clientRepository.save(client);

        return new ClientDTO(client);
    }

    private void copyEntityToDto(ClientDTO dto, Client client, Address address){
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setPhone(dto.getPhone());

        if(address == null){
            address = new Address();
        }

        address.setStreet(dto.getAddress().getStreet());
        address.setNumber(dto.getAddress().getNumber());
        address.setCity(dto.getAddress().getCity());
        address.setState(dto.getAddress().getState());
        address.setNeighborhood(dto.getAddress().getNeighborhood());
        address.setZipCode(dto.getAddress().getZipCode());

        client.setAddress(address);
    }
}
