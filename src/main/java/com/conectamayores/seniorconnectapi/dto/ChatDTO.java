package com.conectamayores.seniorconnectapi.dto;

import java.time.LocalDateTime;

public class ChatDTO {

    private Integer chatId;
    private String mensaje;
    private LocalDateTime hora;
    private String estado;
    private SolicitudDTO solicitud;
    private AdultoMayorDTO adultoMayor;
    private VoluntarioDTO voluntario;

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public SolicitudDTO getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudDTO solicitud) {
        this.solicitud = solicitud;
    }

    public AdultoMayorDTO getAdultoMayor() {
        return adultoMayor;
    }

    public void setAdultoMayor(AdultoMayorDTO adultoMayor) {
        this.adultoMayor = adultoMayor;
    }

    public VoluntarioDTO getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(VoluntarioDTO voluntario) {
        this.voluntario = voluntario;
    }
}
