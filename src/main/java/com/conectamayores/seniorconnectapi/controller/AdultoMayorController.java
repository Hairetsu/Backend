package com.conectamayores.seniorconnectapi.controller;


import com.conectamayores.seniorconnectapi.config.AdultoMayorMapper;
import com.conectamayores.seniorconnectapi.dto.AdultoMayorDTO;
import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;
import com.conectamayores.seniorconnectapi.exceptions.AdultoMayorNoEncontradoException;
import com.conectamayores.seniorconnectapi.service.impl.AdultoMayorServiceImpl;
import com.conectamayores.seniorconnectapi.service.impl.SolicitudDeAsistenciaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adulto")
@RequiredArgsConstructor
public class AdultoMayorController {

    private final AdultoMayorServiceImpl adultoMayorService;
    private final SolicitudDeAsistenciaServiceImpl solicitudDeAsistenciaService;


    @PostMapping
    public ResponseEntity<AdultoMayorDTO> createAdultoMayor(@RequestBody AdultoMayorDTO adultoMayorDTO) throws Exception {

        AdultoMayor adultoMayor = AdultoMayorMapper.dtoToEntity(adultoMayorDTO);

        AdultoMayor createdAdultoMayor = adultoMayorService.save(adultoMayor);

        AdultoMayorDTO createdAdultoMayorDTO = AdultoMayorMapper.entityToDto(createdAdultoMayor);

        return new ResponseEntity<>(createdAdultoMayorDTO, HttpStatus.CREATED);
    }

    @GetMapping("/adulto-mayor")
    public ResponseEntity<List<AdultoMayor>> obtenerTodosLosAdultoMayor() {
        List<AdultoMayor> adultosMayores = adultoMayorService.getAllAdultosMayores();

        if (adultosMayores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity<>(adultosMayores, HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdultoMayor(@PathVariable("id") Integer id) {
        adultoMayorService.deleteAdultoMayor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdultoMayor> updateAdultoMayor(@PathVariable("id") Integer id, @RequestBody AdultoMayor adultoMayor) throws AdultoMayorNoEncontradoException {
        AdultoMayor adultoMayorExistente = adultoMayorService.obtenerAdultoMayorPorId(id);
        adultoMayorExistente.setEdad(adultoMayor.getEdad());
        adultoMayorExistente.setGustos(adultoMayor.getGustos());
        // Actualizar otros campos según sea necesario

        AdultoMayor adultoMayorActualizado = adultoMayorService.updateAdultoMayor(adultoMayorExistente);
        return ResponseEntity.ok(adultoMayorActualizado);
    }

    @PostMapping("/adultos-mayores/{id}/solicitudes")
    public ResponseEntity<String> crearSolicitudDeAsistencia(@PathVariable("id") Integer adultoMayorId, @RequestBody SolicitudDeAsistencia solicitudDeAsistencia) throws AdultoMayorNoEncontradoException {
        AdultoMayor adultoMayor = adultoMayorService.obtenerAdultoMayorPorId(adultoMayorId);
        solicitudDeAsistencia.setAdultoMayor(adultoMayor);
        solicitudDeAsistenciaService.crearSolicitud(solicitudDeAsistencia);
        return ResponseEntity.ok("Solicitud de asistencia creada con éxito");
    }




}
















