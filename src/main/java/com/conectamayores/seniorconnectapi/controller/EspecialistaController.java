package com.conectamayores.seniorconnectapi.controller;

import com.conectamayores.seniorconnectapi.config.EspecialistaMapper;
import com.conectamayores.seniorconnectapi.dto.EspecialistaDTO;
import com.conectamayores.seniorconnectapi.model.Especialista;
import com.conectamayores.seniorconnectapi.service.impl.EspecialistaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/especialista")
@RequiredArgsConstructor
public class EspecialistaController {

    private final EspecialistaServiceImpl especialistaService;
    @GetMapping("/{id}")
    public ResponseEntity<EspecialistaDTO> getEspecialistaById(@PathVariable Integer id) throws Exception {
        Especialista especialista = especialistaService.getEspecialistaById(id);
        if (especialista == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        EspecialistaDTO especialistaDTO = EspecialistaMapper.entityToDto(especialista);
        return new ResponseEntity<>(especialistaDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EspecialistaDTO> createEspecialista(@RequestBody EspecialistaDTO especialistaDTO) {
        Especialista especialista = EspecialistaMapper.dtoToEntity(especialistaDTO);
        Especialista createdEspecialista = especialistaService.createEspecialista(especialista);
        EspecialistaDTO createdEspecialistaDTO = EspecialistaMapper.entityToDto(createdEspecialista);
        return new ResponseEntity<>(createdEspecialistaDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialistaDTO> updateEspecialista(@PathVariable Integer id, @RequestBody EspecialistaDTO especialistaDTO) {
        Especialista especialista = EspecialistaMapper.dtoToEntity(especialistaDTO);
        try {
            Especialista updatedEspecialista = especialistaService.updateEspecialista(especialista, id);
            EspecialistaDTO updatedEspecialistaDTO = EspecialistaMapper.entityToDto(updatedEspecialista);
            return new ResponseEntity<>(updatedEspecialistaDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialista(@PathVariable Integer id) {
        especialistaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
