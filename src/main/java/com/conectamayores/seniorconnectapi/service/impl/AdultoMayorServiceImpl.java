package com.conectamayores.seniorconnectapi.service.impl;


import com.conectamayores.seniorconnectapi.exceptions.AdultoMayorNoEncontradoException;
import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.repository.AdultoMayorRepository;
import com.conectamayores.seniorconnectapi.repository.UsuarioRepository;
import com.conectamayores.seniorconnectapi.service.IAdultoMayoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdultoMayorServiceImpl implements IAdultoMayoresService <AdultoMayor,Integer> {


    private final AdultoMayorRepository adultoMayorRepository;
    private UsuarioRepository usuarioRepository;

    @Override
    public AdultoMayor createAdultoMayor(AdultoMayor adultoMayor) {
        return adultoMayorRepository.save(adultoMayor);
    }


    @Override
    public Optional<AdultoMayor> getAdultoMayorById(Integer id) {
        return adultoMayorRepository.findById(id);
    }

    @Override
    public List<AdultoMayor> getAllAdultosMayores() {
        return adultoMayorRepository.findAll();
    }

    @Override
    public void deleteAdultoMayor(Integer id) {
        adultoMayorRepository.deleteById(id);
    }

    @Override
    public AdultoMayor updateAdultoMayor(AdultoMayor adultoMayor) {
        return adultoMayorRepository.save(adultoMayor);
    }

    @Override
    public AdultoMayor save(AdultoMayor adultoMayor) throws Exception {
        // Antes de guardar adultoMayor, asegúrate de que su usuario asociado también esté guardado
        if (adultoMayor.getUsuario() != null && (adultoMayor.getUsuario().getIdUsuario() == null || adultoMayor.getUsuario().getIdUsuario() == 0)) {
            usuarioRepository.save(adultoMayor.getUsuario());
        }
        return adultoMayorRepository.save(adultoMayor);
    }

    @Override
    public AdultoMayor obtenerAdultoMayorPorId(int adultoMayorId) throws AdultoMayorNoEncontradoException {
        Optional<AdultoMayor> optionalAdultoMayor = adultoMayorRepository.findById(adultoMayorId);
        if (optionalAdultoMayor.isPresent()) {
            return optionalAdultoMayor.get();
        } else {
            throw new AdultoMayorNoEncontradoException("No se encontró ningún adulto mayor con el ID proporcionado.");
        }
    }

    @Override
    public AdultoMayor editarAdultoMayor(AdultoMayor adultoMayor) {
        return adultoMayorRepository.save(adultoMayor);
    }

    @Override
    public AdultoMayor update(AdultoMayor adultoMayor, Integer id) throws Exception {
        AdultoMayor existingAdultoMayor = adultoMayorRepository.findById(id)
                .orElseThrow(() -> new Exception("Adulto Mayor no encontrado con ID: " + id));

        // Actualizar los campos del adulto mayor existente
        existingAdultoMayor.setNombreCompleto(adultoMayor.getNombreCompleto());
        existingAdultoMayor.setEdad(adultoMayor.getEdad());
        existingAdultoMayor.setGustos(adultoMayor.getGustos());
        existingAdultoMayor.setGenero(adultoMayor.getGenero());

        // Guardar los cambios en el repositorio

        return adultoMayorRepository.save(existingAdultoMayor);
    }

    @Override
    public List<AdultoMayor> readAll() {
        return null;
    }

    @Override
    public AdultoMayor readById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) throws Exception {

    }


    public AdultoMayor obtenerPorId(Integer adultoMayorId) {
        return adultoMayorRepository.findById(adultoMayorId)
                .orElseThrow(() -> new RuntimeException("No se encontró al adulto mayor con el ID: " + adultoMayorId));
    }




}


