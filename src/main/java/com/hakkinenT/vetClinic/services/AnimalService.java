package com.hakkinenT.vetClinic.services;

import com.hakkinenT.vetClinic.dto.AnimalDTO;
import com.hakkinenT.vetClinic.entities.Animal;
import com.hakkinenT.vetClinic.entities.AnimalGender;
import com.hakkinenT.vetClinic.entities.Client;
import com.hakkinenT.vetClinic.entities.Species;
import com.hakkinenT.vetClinic.repositories.AnimalRepository;
import com.hakkinenT.vetClinic.repositories.ClientRepository;
import com.hakkinenT.vetClinic.repositories.SpeciesRepository;
import com.hakkinenT.vetClinic.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Transactional
    public AnimalDTO insert(AnimalDTO dto){
        try {
            Animal animal = new Animal();

            copyDtoToEntity(dto, animal);

            animal = animalRepository.save(animal);

            return new AnimalDTO(animal);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }
    }

    private void copyDtoToEntity(AnimalDTO dto, Animal animal){
        animal.setName(dto.getName());
        animal.setAge(dto.getAge());
        animal.setGender(AnimalGender.valueOf(dto.getGender()));

        Client client = clientRepository.getReferenceById(dto.getClient().getId());
        client.getAnimals().add(animal);

        Species species = speciesRepository.getReferenceById(dto.getSpecies().getId());
        species.getAnimals().add(animal);

        animal.setClient(client);
        animal.setSpecies(species);

    }

    @Transactional
    public AnimalDTO update(Long id, AnimalDTO dto){
        try{
            Animal animal = animalRepository.getReferenceById(id);

            animal.setName(dto.getName());
            animal.setAge(dto.getAge());
            animal.setGender(AnimalGender.valueOf(dto.getGender()));

            animal = animalRepository.save(animal);

            return new AnimalDTO(animal);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }
    }

    @Transactional(readOnly = true)
    public List<AnimalDTO> searchAllAnimalByClientName(String name){

        List<AnimalDTO> animals = animalRepository.searchAllAnimalByClientName(name);


        return animals;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!animalRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }

        animalRepository.deleteById(id);
    }
}
