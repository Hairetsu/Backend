package com.conectamayores.seniorconnectapi.repository;

import com.conectamayores.seniorconnectapi.dto.EspecialistaDTO;
import com.conectamayores.seniorconnectapi.model.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EspecialistaRepository extends JpaRepository<Especialista, Integer> {


}
