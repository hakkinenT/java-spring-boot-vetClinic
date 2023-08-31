package com.hakkinenT.vetClinic.controllers;

import com.hakkinenT.vetClinic.dto.AnimalDTO;
import com.hakkinenT.vetClinic.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalDTO> insert(@RequestBody AnimalDTO dto){
        dto = animalService.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AnimalDTO> update(@PathVariable Long id, @RequestBody AnimalDTO dto){
        dto = animalService.update(id, dto);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> searchAllAnimalByClientName(
            @RequestParam(defaultValue = "", name = "client") String name){
        List<AnimalDTO> animals = animalService.searchAllAnimalByClientName(name);
        return ResponseEntity.ok(animals);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
