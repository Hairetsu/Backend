package com.conectamayores.seniorconnectapi.dto;

import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.Voluntario;

import java.sql.Time;

public class SolicitudDTO {



    private Integer adultoMayorId;
    private String estado;
    private Time hora;
    private String mensaje;

    public Integer getAdultoMayorId() {
        return adultoMayorId;
    }

    public void setAdultoMayorId(Integer adultoMayorId) {
        this.adultoMayorId = adultoMayorId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


}
