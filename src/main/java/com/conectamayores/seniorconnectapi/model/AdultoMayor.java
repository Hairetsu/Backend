package com.conectamayores.seniorconnectapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class AdultoMayor   {

    @Getter @Setter
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdultoMayor;

    @Getter @Setter
    @Column(length = 50, nullable = false)
    private String nombreCompleto;

    @Getter @Setter
    @Column(name = "edad", nullable = false)
    @Min(value = 1, message = "La edad mínima permitida es 1")
    @Max(value = 99, message = "La edad máxima permitida es 99")
    private int edad;

    @Getter @Setter
    @Column(name = "gustos", nullable = false, length = 100)
    private String gustos;

    @Getter @Setter
    @Column(name = "genero", nullable = false, length = 50)
    private String genero;

    @Getter @Setter
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Getter @Setter
    @JsonIgnore
    @OneToMany(mappedBy = "adultoMayor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SolicitudDeAsistencia> solicitudesDeAsistencia;


}
