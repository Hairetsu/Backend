package com.conectamayores.seniorconnectapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class SolicitudRutina {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignacionTipoRutina;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @Column(name = "fechacreacion", nullable = false)
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adulto_mayor_idadultomayor", nullable = false)
    private AdultoMayor adultoMayor;
}
