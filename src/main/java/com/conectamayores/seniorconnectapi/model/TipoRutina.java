package com.conectamayores.seniorconnectapi.model;


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
public class TipoRutina {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignacionTipoRutina;
    private int tipoRutinaId;

    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 20, nullable = false)
    private String descripcion;

    @Column(name = "duracion", nullable = false)
    private int duracion;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asignacion_tipo_rutina_asignacion_tipo_rutina_id", nullable = false)
    private AsignacionTipoRutina asignacionTipoRutina;
}
