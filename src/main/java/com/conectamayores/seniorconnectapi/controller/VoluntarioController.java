package com.conectamayores.seniorconnectapi.controller;

import com.conectamayores.seniorconnectapi.config.VoluntarioMapper;
import com.conectamayores.seniorconnectapi.dto.VoluntarioDTO;
import com.conectamayores.seniorconnectapi.model.Voluntario;
import com.conectamayores.seniorconnectapi.repository.VoluntarioRepository;
import com.conectamayores.seniorconnectapi.service.impl.VoluntarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/voluntario")
@RequiredArgsConstructor
public class VoluntarioController {


    private final VoluntarioServiceImpl voluntarioService;

    @PostMapping
    public ResponseEntity<VoluntarioDTO> createVoluntario(@RequestBody VoluntarioDTO voluntarioDTO) throws Exception {

        Voluntario voluntario = VoluntarioMapper.dtoToEntity(voluntarioDTO);
        Voluntario createVoluntario = voluntarioService.save(voluntario);
        VoluntarioDTO createdAdultoMayorDTO = VoluntarioMapper.entityToDto(createVoluntario);
        return new ResponseEntity<>(createdAdultoMayorDTO, HttpStatus.CREATED);

    }

    @GetMapping("/voluntarios")
    public ResponseEntity<List<Voluntario>> getAllVoluntario() {
        List<Voluntario> voluntarioListList = voluntarioService.obtenerTodosLosVoluntarios();
        return new ResponseEntity<>(voluntarioListList, HttpStatus.OK);
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoluntario(@PathVariable("id") Integer id) throws Exception {
        voluntarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity <?> FindVoluntario (@PathVariable String nombre){

        try {
            List<Voluntario> voluntarios =voluntarioService.buscarVoluntario(nombre);
            StringBuilder response = new StringBuilder();
            for (Voluntario voluntario : voluntarios) {
                response.append("Nombre: ").append(voluntario.getNombreCompleto())
                        .append("\nEdad: ").append(voluntario.getEdad())
                        .append("\nGustos: ").append(voluntario.getGustos())
                        .append("\n\n");
            }
            return ResponseEntity.status(HttpStatus.OK).body(response.toString());
        } catch (NoSuchElementException e) {
            String mensajeError = "No se encontraron voluntarios con el nombre " + nombre;
            return new ResponseEntity<>(mensajeError, HttpStatus.NOT_FOUND);
        }


    }



}
