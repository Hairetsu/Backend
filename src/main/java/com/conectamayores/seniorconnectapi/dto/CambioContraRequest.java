package com.conectamayores.seniorconnectapi.dto;

public class CambioContraRequest {
    private String contraActual;
    private String nuevaContra;

    public String getContraActual() {
        return contraActual;
    }

    public void setContraActual(String contraActual) {
        this.contraActual = contraActual;
    }

    public String getNuevaContra() {
        return nuevaContra;
    }

    public void setNuevaContra(String nuevaContra) {
        this.nuevaContra = nuevaContra;
    }
}

