package com.conectamayores.seniorconnectapi.model;


import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Familiar  {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdultoMayor;

    @Getter  @Setter
    @Column(length = 50, nullable = false)
    private String nombreCompleto;

    @Getter  @Setter
    @Column(name = "edad", nullable = false, length = 3)
    private int edad;

    @Column(name = "gustos", nullable = false, length = 100)
    private String gustos;

    @Getter  @Setter
    @Column(length = 50, nullable = false)
    private String tipoUsuario;

}
