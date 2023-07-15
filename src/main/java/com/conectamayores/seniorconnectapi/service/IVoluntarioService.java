package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.model.Voluntario;

import java.util.List;

public interface IVoluntarioService <V, I extends Number> extends ICRUD<Voluntario, Integer> {
    Voluntario crearVoluntario(Voluntario voluntario);
    Voluntario obtenerVoluntarioPorId(Integer id);
    List<Voluntario> obtenerTodosLosVoluntarios();
    void eliminarVoluntario(Integer id);
    Voluntario actualizarVoluntario(Voluntario voluntario);

    List<Voluntario> buscarVoluntario(String nombre);

}
