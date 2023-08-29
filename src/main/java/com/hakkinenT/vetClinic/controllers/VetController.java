package com.hakkinenT.vetClinic.controllers;

import com.hakkinenT.vetClinic.dto.VetDTO;
import com.hakkinenT.vetClinic.services.VetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/vets")
public class VetController {
    @Autowired
    private VetService vetService;

    @PostMapping
    public ResponseEntity<VetDTO> insert(@Valid @RequestBody VetDTO dto){
        dto = vetService.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VetDTO> update(@PathVariable Long id, @Valid @RequestBody VetDTO dto){
        dto = vetService.update(id, dto);

        return ResponseEntity.ok(dto);
    }
}
