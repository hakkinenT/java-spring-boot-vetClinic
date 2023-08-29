package com.hakkinenT.vetClinic.services;

import com.hakkinenT.vetClinic.dto.VetDTO;
import com.hakkinenT.vetClinic.entities.Address;
import com.hakkinenT.vetClinic.entities.Vet;
import com.hakkinenT.vetClinic.repositories.VetRepository;
import com.hakkinenT.vetClinic.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VetService {
    @Autowired
    private VetRepository vetRepository;

    @Transactional
    public VetDTO insert(VetDTO dto) {
        Vet vet = new Vet();
        copyDtoToEntity(dto, vet, null);

        vet = vetRepository.save(vet);

        return new VetDTO(vet);
    }

    private void copyDtoToEntity(VetDTO dto, Vet vet, Address address) {
        vet.setName(dto.getName());
        vet.setEmail(dto.getEmail());
        vet.setPhone(dto.getPhone());

        if (address == null) {
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

    @Transactional
    public VetDTO update(Long id, VetDTO dto) {
        try {
            Vet vet = vetRepository.getReferenceById(id);
            Address address = new Address();
            address.setId(vet.getAddress().getId());

            copyDtoToEntity(dto, vet, address);

            vet = vetRepository.save(vet);

            return new VetDTO(vet);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(readOnly = true)
    public List<VetDTO> findAll() {
        List<Vet> vets = vetRepository.findAll();

        return vets.stream().map(vet -> new VetDTO(vet)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public VetDTO findById(Long id) {
        Vet vet = vetRepository.findById(id)
                                .orElseThrow(
                                        () -> new ResourceNotFoundException("Recurso não encontrado."));

        return new VetDTO(vet);
    }
}
