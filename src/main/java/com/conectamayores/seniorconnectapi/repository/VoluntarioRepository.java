package com.conectamayores.seniorconnectapi.repository;

import com.conectamayores.seniorconnectapi.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer> {

    @Query("SELECT v FROM Voluntario v WHERE v.nombreCompleto = :nombre")
    List<Voluntario> buscarNombre(@Param("nombre") String nombre);


}
