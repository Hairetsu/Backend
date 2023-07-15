package com.conectamayores.seniorconnectapi.config;

import com.conectamayores.seniorconnectapi.dto.AdultoMayorDTO;
import com.conectamayores.seniorconnectapi.dto.UsuarioDTO;
import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.Usuario;
import org.springframework.stereotype.Component;


@Component
public class UsuarioMapper {

    public static UsuarioDTO entityToDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNombreUsuario(usuario.getNombreUsuario());
        dto.setEstado(usuario.isEstado());
        dto.setClave(usuario.getClave());
        return dto;
    }

    public static Usuario dtoToEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setEstado(dto.isEstado());
        usuario.setClave(dto.getClave());

        return usuario;
    }
}
