package com.conectamayores.seniorconnectapi.config;

import com.conectamayores.seniorconnectapi.dto.SolicitudDTO;
import com.conectamayores.seniorconnectapi.dto.SolicitudParaChatDTO;
import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.Chat;
import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;
import com.conectamayores.seniorconnectapi.model.Voluntario;

import java.util.ArrayList;
import java.util.List;

public class SolicitudMapper {

    public static SolicitudParaChatDTO entityToDto (SolicitudDeAsistencia solicitud) {
        SolicitudParaChatDTO dto = new SolicitudParaChatDTO();

        dto.setSolicitudId(solicitud.getSolicitudDeAsistenciaId());
        dto.setEstado(solicitud.getEstado());
        return dto;
    }

    public static SolicitudDeAsistencia dtoToEntity(SolicitudDTO dto) {
        SolicitudDeAsistencia solicitud = new SolicitudDeAsistencia();

        // Establece el ID del adulto mayor en la entidad AdultoMayor
        AdultoMayor adultoMayor = new AdultoMayor();
        adultoMayor.setIdAdultoMayor(dto.getAdultoMayorId()); // Suponiendo que la entidad AdultoMayor tiene un método setIdAdultoMayor
        solicitud.setAdultoMayor(adultoMayor);

        Chat chat = new Chat();
        chat.setMensaje(dto.getMensaje()); // Suponiendo que la entidad Chat tiene un método setMensaje
        List<Chat> chats = new ArrayList<>();
        chats.add(chat);
        solicitud.setChat(chats);
        return solicitud;
    }


}
