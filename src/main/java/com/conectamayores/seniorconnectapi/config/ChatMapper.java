package com.conectamayores.seniorconnectapi.config;

import com.conectamayores.seniorconnectapi.dto.ChatDTO;
import com.conectamayores.seniorconnectapi.dto.VoluntarioDTO;
import com.conectamayores.seniorconnectapi.model.Chat;
import com.conectamayores.seniorconnectapi.model.Voluntario;
import org.springframework.stereotype.Component;


@Component
public class ChatMapper {

    public ChatDTO entityToDto(Chat chat) {
        ChatDTO dto = new ChatDTO();


        dto.setChatId(chat.getIdChat());
        dto.setMensaje(chat.getMensaje());
        dto.setHora(chat.getHora());
        dto.setEstado(chat.getEstado());
        dto.setAdultoMayor(AdultoMayorMapper.entityToDto(chat.getUsuario().getAdultoMayor()));
        dto.setVoluntario(VoluntarioMapper.entityToDto(chat.getUsuario().getVoluntario()));

        return dto;
    }

    public Chat dtoToEntity(ChatDTO dto) {
        Chat chat = new Chat();

        chat.setIdChat(dto.getChatId());
        chat.setMensaje(dto.getMensaje());
        chat.setHora(dto.getHora());
        chat.setEstado(dto.getEstado());

        chat.setUsuario(AdultoMayorMapper.dtoToEntity(dto.getAdultoMayor()).getUsuario());
        chat.setUsuario(VoluntarioMapper.dtoToEntity(dto.getVoluntario()).getUsuario());

        return chat;
    }


}
