package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.model.Familiar;

import java.util.List;

public interface IFamiliarService<F, I extends Number> extends ICRUD<Familiar,Integer> {

    Familiar createFamiliar(Familiar familiar);
    Familiar getFamiliarById(Long id);
    List<Familiar> getAllFamiliares();
    void deleteFamiliar(Long id);
    Familiar updateFamiliar(Familiar familiar);
}
