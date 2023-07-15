package com.conectamayores.seniorconnectapi.repository;

import com.conectamayores.seniorconnectapi.model.Especialista;
import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudDeAsistenciaRepository extends JpaRepository<SolicitudDeAsistencia, Integer> {


}
