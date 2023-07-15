package com.conectamayores.seniorconnectapi.service;

import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;

import java.util.List;

public interface ISolicitudDeAsistencia  <F, I extends Number> extends ICRUD<SolicitudDeAsistencia,Integer>{

    SolicitudDeAsistencia crearSolicitud(SolicitudDeAsistencia solicitud);

    SolicitudDeAsistencia obtenerSolicitud(int id);

    List<SolicitudDeAsistencia> obtenerTodasLasSolicitudes();

    List<SolicitudDeAsistencia> obtenerSolicitudesPorEstado(String estado);

    void actualizarSolicitud(SolicitudDeAsistencia solicitud, String nuevoEstado);

    void eliminarSolicitud(int id);
}
