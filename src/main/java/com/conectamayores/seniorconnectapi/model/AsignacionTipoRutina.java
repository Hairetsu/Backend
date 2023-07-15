package com.conectamayores.seniorconnectapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class AsignacionTipoRutina {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignacionTipoRutina;

    @Column(name = "hora")
    private Time hora;
    @ManyToOne
    @JoinColumn(name = "solicitud_rutina_solicitud_rutina_id")
    private SolicitudRutina solicitudRutina;

    @ManyToOne
    @JoinColumn(name = "tipo_rutina_tipo_rutina_id")
    private TipoRutina tipoRutina;
}
