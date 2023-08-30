package com.hakkinenT.vetClinic.controllers;

import com.hakkinenT.vetClinic.dto.AnimalDTO;
import com.hakkinenT.vetClinic.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
}
