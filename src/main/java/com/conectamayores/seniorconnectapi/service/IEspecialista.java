package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.model.Especialista;
import com.conectamayores.seniorconnectapi.model.Voluntario;

import java.util.List;

public interface IEspecialista  <T, ID extends Number> {

    T save(T entity);
    T findById(Integer id);
    List<T> findAll();
    void delete(ID id);
}
