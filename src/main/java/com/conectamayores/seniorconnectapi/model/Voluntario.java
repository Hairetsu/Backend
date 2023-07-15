package com.conectamayores.seniorconnectapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Voluntario  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Id
    private Integer idVoluntario;

    @Getter  @Setter
    @Column(length = 50, nullable = false)
    private String nombreCompleto;

    @Getter  @Setter
    @Column(name = "edad", nullable = false, length = 3)
    private int edad;

    @Getter  @Setter
    @Column(name = "gustos", nullable = false, length = 100)
    private String gustos;

    @Getter  @Setter
    @Column(name = "genero", nullable = false, length = 15)
    private String genero;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @JsonIgnore
    @OneToMany(mappedBy = "voluntario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SolicitudDeAsistencia> solicitudesDeAsistencia;



}
