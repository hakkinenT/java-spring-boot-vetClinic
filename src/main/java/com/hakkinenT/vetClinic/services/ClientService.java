package com.hakkinenT.vetClinic.services;

import com.hakkinenT.vetClinic.dto.ClientDTO;
import com.hakkinenT.vetClinic.entities.Address;
import com.hakkinenT.vetClinic.entities.Client;
import com.hakkinenT.vetClinic.repositories.ClientRepository;
import com.hakkinenT.vetClinic.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client client = new Client();
        copyDtoToEntity(dto, client, null);

        client = clientRepository.save(client);

        return new ClientDTO(client);
    }

    private void copyDtoToEntity(ClientDTO dto, Client client, Address address) {
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setPhone(dto.getPhone());

        if (address == null) {
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

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client client = clientRepository.getReferenceById(id);
            Address address = new Address();
            address.setId(client.getAddress().getId());

            copyDtoToEntity(dto, client, address);

            client = clientRepository.save(client);
            return new ClientDTO(client);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));
        return new ClientDTO(client);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!clientRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }

        clientRepository.deleteById(id);
    }
}
