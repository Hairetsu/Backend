package com.conectamayores.seniorconnectapi.dto;

public class SolicitudParaChatDTO {

    private Integer solicitudId;
    private String estado;


    // Other properties

    public Integer getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
