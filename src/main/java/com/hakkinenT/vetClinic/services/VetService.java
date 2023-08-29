package com.hakkinenT.vetClinic.services;

import com.hakkinenT.vetClinic.dto.VetDTO;
import com.hakkinenT.vetClinic.entities.Address;
import com.hakkinenT.vetClinic.entities.Vet;
import com.hakkinenT.vetClinic.repositories.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VetService {
    @Autowired
    private VetRepository vetRepository;

    @Transactional
    public VetDTO insert(VetDTO dto){
        Vet vet = new Vet();
        copyDtoToEntity(dto, vet, null);

        vet = vetRepository.save(vet);

        return new VetDTO(vet);
    }

    private void copyDtoToEntity(VetDTO dto, Vet vet, Address address){
        vet.setName(dto.getName());
        vet.setEmail(dto.getEmail());
        vet.setPhone(dto.getPhone());

        if(address == null){
            address = new Address();
        }

        address.setStreet(dto.getAddress().getStreet());
        address.setNumber(dto.getAddress().getNumber());
        address.setCity(dto.getAddress().getCity());
        address.setNeighborhood(dto.getAddress().getNeighborhood());
        address.setZipCode(dto.getAddress().getZipCode());
        address.setState(dto.getAddress().getState());

        vet.setAddress(address);
    }
}
