package com.conectamayores.seniorconnectapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Especialista {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspecialista;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "genero")
    private String genero;

    @ManyToOne
    @JoinColumn(name = "asignacion_tipo_rutina_asignacion_tipo_rutina_id")
    private AsignacionTipoRutina asignacionTipoRutina;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}

