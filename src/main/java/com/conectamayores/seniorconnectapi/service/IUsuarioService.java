package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.exceptions.UsuarioExistenteException;
import com.conectamayores.seniorconnectapi.model.Familiar;
import com.conectamayores.seniorconnectapi.model.Usuario;
import com.conectamayores.seniorconnectapi.model.Voluntario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService <F, I extends Number> extends ICRUD<Usuario,Integer> {


    Usuario save(Usuario usuario); // Create & Update

    Optional<Usuario> findById(Integer id); // Read

    List<Usuario> findAll(); // Read all

    void deleteById(Integer id); // Delete


    Usuario crearUsuario(Usuario usuario) throws UsuarioExistenteException;


    void cambiarClave(String username, String contraseñaActual, String nuevaContraseña);


}
