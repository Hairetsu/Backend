package com.conectamayores.seniorconnectapi.repository;

import com.conectamayores.seniorconnectapi.dto.AdultoMayorDTO;
import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.Usuario;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AdultoMayorRepository extends JpaRepository<AdultoMayor, Integer> {


    @Query("SELECT am.idAdultoMayor AS idAdultoMayor, am.nombreCompleto AS nombreCompleto, am.edad AS edad FROM AdultoMayor am WHERE am.idAdultoMayor = :id")
    AdultoMayorDTO findAdultoMayorDTOById(@Param("id") Integer id);

    List<AdultoMayor> findAll();

    void deleteById(Integer id);


}
