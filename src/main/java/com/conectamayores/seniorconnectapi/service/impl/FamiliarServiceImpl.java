package com.conectamayores.seniorconnectapi.service.impl;

import com.conectamayores.seniorconnectapi.model.Familiar;
import com.conectamayores.seniorconnectapi.repository.FamiliarRepository;
import com.conectamayores.seniorconnectapi.service.IFamiliarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamiliarServiceImpl implements IFamiliarService <Familiar,Integer> {

    private final FamiliarRepository familiarRepository;

    @Override
    public Familiar save(Familiar familiar) throws Exception {
        return familiarRepository.save(familiar);
    }

    @Override
    public Familiar update(Familiar familiar, Integer id) throws Exception {
        return familiarRepository.save(familiar);
    }

    @Override
    public List<Familiar> readAll() throws Exception {
        return familiarRepository.findAll();
    }

    @Override
    public Familiar readById(Integer id) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {
        familiarRepository.deleteById(id);
    }

    @Override
    public Familiar createFamiliar(Familiar familiar) {
        return familiarRepository.save(familiar);
    }

    @Override
    public Familiar getFamiliarById(Long id) {
        return null;
    }

    @Override
    public List<Familiar> getAllFamiliares() {
        return null;
    }

    @Override
    public void deleteFamiliar(Long id) {

    }

    @Override
    public Familiar updateFamiliar(Familiar familiar) {
        return null;
    }
}
