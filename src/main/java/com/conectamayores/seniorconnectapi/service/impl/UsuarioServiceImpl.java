package com.conectamayores.seniorconnectapi.service.impl;

import com.conectamayores.seniorconnectapi.dto.UsuarioDTO;
import com.conectamayores.seniorconnectapi.exceptions.*;
import com.conectamayores.seniorconnectapi.model.Usuario;
import com.conectamayores.seniorconnectapi.repository.UsuarioRepository;
import com.conectamayores.seniorconnectapi.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService{

    private final UsuarioRepository usuarioRepository;


    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return  usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws UsuarioExistenteException {

        if(usuarioRepository.existsByNombreUsuario(usuario.getNombreUsuario())) {
            throw new UsuarioExistenteException("El nombre de usuario ya está registrado");
        } else {
            return usuarioRepository.save(usuario);
        }

    }

    @Override
    public void cambiarClave(String username, String contraseñaActual, String nuevaContraseña) throws UsuarioNoEncontradoException, ContraInvalidaException, ContraIgualException {
        Usuario usuario = usuarioRepository.findByNombreUsuario(username);

        if (usuario == null) {
            throw new UsuarioNoEncontradoException("El usuario no existe");
        } else {
            if (!usuario.getClave().equals(contraseñaActual)) {
                throw new ContraInvalidaException("La contraseña actual es incorrecta");
            } else {
                if (usuario.getClave().equals(nuevaContraseña)) {
                    throw new ContraIgualException("La nueva contraseña no puede ser igual a la actual");
                } else {
                    usuario.setClave(nuevaContraseña);
                    usuarioRepository.save(usuario);
                }
            }

        }

    }

    public void loginUser(String nombreUsuario, String clave) throws UsuarioNoEncontradoException, ContraIncorrectaException {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException("El usuario no existe");
        }
        if (!usuario.getClave().equals(clave)) {
            throw new ContraIncorrectaException("Contraseña incorrecta");
        }
        // Lógica adicional de autenticación si es necesario
    }


    @Override
    public Object save(Object o) throws Exception {
        return null;
    }

    @Override
    public Object update(Object o, Object o2) throws Exception {
        return null;
    }

    @Override
    public List readAll() throws Exception {
        return usuarioRepository.findAll();
    }


    @Override
    public Object readById(Object o) throws Exception {
        return null;
    }

    @Override
    public void delete(Object o) throws Exception {

    }

    private List<UsuarioDTO> convertirAUsuarioDTO(List<Usuario> usuarios) {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            // Copiar los datos relevantes de Usuario a UsuarioDTO

            usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
            // No copiar la contraseña
            usuariosDTO.add(usuarioDTO);
        }
        return usuariosDTO;
    }

    public List<UsuarioDTO> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return convertirAUsuarioDTO(usuarios);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
}
