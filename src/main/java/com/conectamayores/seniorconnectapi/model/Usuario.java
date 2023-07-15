package com.conectamayores.seniorconnectapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance (strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Usuario {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Getter
    @Setter
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(max = 20, message = "El nombre de usuario no puede tener más de 20 caracteres")
    @Column(name = "nombreusuario", length = 20, nullable = false)
    private String nombreUsuario;

    @Getter  @Setter
    @Column(name = "contraseña", length = 100, nullable = false)
    private String clave;

    @Getter  @Setter
    @Column(name = "estado", nullable = false)
    private boolean estado;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private AdultoMayor adultoMayor;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Voluntario voluntario;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Especialista especialista;

    //@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "chat_chat_id", nullable = false, unique = true)
    //private Chat chat;


}
