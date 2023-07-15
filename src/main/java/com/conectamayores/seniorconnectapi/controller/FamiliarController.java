package com.conectamayores.seniorconnectapi.controller;

import com.conectamayores.seniorconnectapi.model.Familiar;
import com.conectamayores.seniorconnectapi.repository.FamiliarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familiar")
@RequiredArgsConstructor
public class FamiliarController {

    private final FamiliarRepository familiarRepository;

    @PostMapping
    public ResponseEntity<Familiar> createFamiliar(@RequestBody Familiar familiar) {

        Familiar familiar1 =familiarRepository.save(familiar);
        return new ResponseEntity<>(familiar1, HttpStatus.CREATED);
    }

    @GetMapping("/familiares")
    public ResponseEntity<List<Familiar>> getAllFamiliar () {
        List<Familiar> familiarList =familiarRepository.findAll();
        return new ResponseEntity<>(familiarList, HttpStatus.OK);
    }

    @PutMapping("/familiares/{id}")
    public ResponseEntity <Familiar> updateFamiliar (@PathVariable("id") Integer id, @RequestBody Familiar familiar) {

        Familiar familiarFound =familiarRepository.findById(Math.toIntExact(id)).orElse(new Familiar());
        familiarFound.setGustos(familiar.getGustos());
        familiarFound.setEdad(familiar.getEdad());
        return new ResponseEntity<>(familiarRepository.save(familiar), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteFamiliar (@PathVariable ("id") Integer id){
        familiarRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
