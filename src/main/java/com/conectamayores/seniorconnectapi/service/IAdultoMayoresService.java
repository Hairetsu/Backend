package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.exceptions.AdultoMayorNoEncontradoException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;


public interface IAdultoMayoresService<A, I extends Number> extends ICRUD<AdultoMayor,Integer>{

    AdultoMayor createAdultoMayor(AdultoMayor adultoMayor);
    Optional<AdultoMayor> getAdultoMayorById(Integer id) throws ChangeSetPersister.NotFoundException;
    List<AdultoMayor> getAllAdultosMayores();
    void deleteAdultoMayor(Integer id);
    AdultoMayor updateAdultoMayor(AdultoMayor adultoMayor);

    AdultoMayor obtenerAdultoMayorPorId(int adultoMayorId) throws AdultoMayorNoEncontradoException;

    AdultoMayor editarAdultoMayor(AdultoMayor adultoMayor);



}
