package com.conectamayores.seniorconnectapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class AdultoMayorDTO {
    @NotBlank(message = "El nombre completo es obligatorio")
    private String nombreCompleto;

    @Min(value = 0, message = "La edad debe ser un valor positivo")
    private int edad;

    @NotBlank(message = "Los gustos son obligatorios")
    private String gustos;

    @NotBlank(message = "El género es obligatorio")
    private String genero;


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGustos() {
        return gustos;
    }

    public void setGustos(String gustos) {
        this.gustos = gustos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


}
