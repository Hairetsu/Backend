package com.conectamayores.seniorconnectapi.config;

import com.conectamayores.seniorconnectapi.dto.EspecialistaDTO;
import com.conectamayores.seniorconnectapi.model.Especialista;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EspecialistaMapper {

    public static EspecialistaDTO entityToDto(Especialista especialista) {
        EspecialistaDTO especialistaDTO = new EspecialistaDTO();
        especialistaDTO.setId(especialista.getIdEspecialista());
        especialistaDTO.setNombreCompleto(especialista.getNombre());
        especialistaDTO.setEdad(especialista.getEdad());
        especialistaDTO.setEspecialidad(especialista.getEspecialidad());
        return especialistaDTO;
    }

    public static Especialista dtoToEntity(EspecialistaDTO especialistaDTO) {
        Especialista especialista = new Especialista();
        especialista.setIdEspecialista(especialistaDTO.getId());
        especialista.setNombre(especialistaDTO.getNombreCompleto());
        especialista.setEdad(especialistaDTO.getEdad());
        especialista.setEspecialidad(especialistaDTO.getEspecialidad());
        return especialista;
    }

    public List<EspecialistaDTO> entityListToDtoList(List<Especialista> especialistas) {

        List<EspecialistaDTO> especialistaDTOList = new ArrayList<>();
        for (Especialista especialista : especialistas) {
            EspecialistaDTO especialistaDTO = new EspecialistaDTO();
            especialistaDTO.setId(especialista.getIdEspecialista());
            especialistaDTO.setNombreCompleto(especialista.getNombre());
            especialistaDTO.setEspecialidad(especialista.getEspecialidad());


            especialistaDTOList.add(especialistaDTO);
        }
        return especialistaDTOList;
    }
}
