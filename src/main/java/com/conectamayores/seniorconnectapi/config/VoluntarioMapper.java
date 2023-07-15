package com.conectamayores.seniorconnectapi.config;

import com.conectamayores.seniorconnectapi.dto.AdultoMayorDTO;
import com.conectamayores.seniorconnectapi.dto.VoluntarioDTO;
import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.Voluntario;
import org.springframework.stereotype.Component;

@Component
public class VoluntarioMapper {




    public static VoluntarioDTO entityToDto(Voluntario voluntario) {
        VoluntarioDTO dto = new VoluntarioDTO();
        dto.setNombreCompleto(voluntario.getNombreCompleto());
        dto.setEdad(voluntario.getEdad());
        dto.setGustos(voluntario.getGustos());
        dto.setGenero(voluntario.getGenero());

        return dto;
    }

    public static Voluntario dtoToEntity(VoluntarioDTO dto) {
        Voluntario voluntario = new Voluntario();
        voluntario.setNombreCompleto(dto.getNombreCompleto());
        voluntario.setEdad(dto.getEdad());
        voluntario.setGustos(dto.getGustos());
        voluntario.setGenero(dto.getGenero());

        return voluntario;
    }


}
