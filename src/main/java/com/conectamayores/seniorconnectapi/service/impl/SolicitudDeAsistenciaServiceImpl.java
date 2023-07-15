package com.conectamayores.seniorconnectapi.service.impl;

import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import com.conectamayores.seniorconnectapi.model.Chat;
import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;
import com.conectamayores.seniorconnectapi.model.Voluntario;
import com.conectamayores.seniorconnectapi.repository.SolicitudDeAsistenciaRepository;
import com.conectamayores.seniorconnectapi.service.ISolicitudDeAsistencia;
import com.pubnub.api.PubNub;
import com.pubnub.api.PubNubException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SolicitudDeAsistenciaServiceImpl implements ISolicitudDeAsistencia {

    @Autowired
    private final SolicitudDeAsistenciaRepository solicitudDeAsistenciaRepository;
    private  final PubNub pubNub;
    private  final ChatServiceImpl chatService;


    @Override
    public Object save(Object o) throws Exception {
        return null;
    }

    @Override
    public Object update(Object o, Object o2) {
        return null;
    }

    @Override
    public List readAll() throws Exception {
        return null;
    }

    @Override
    public Object readById(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) throws Exception {

    }

    @Override
    public SolicitudDeAsistencia crearSolicitud(SolicitudDeAsistencia solicitud) {
        return solicitudDeAsistenciaRepository.save(solicitud);
    }

    @Override
    public SolicitudDeAsistencia obtenerSolicitud(int id) {
        return solicitudDeAsistenciaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró la solicitud de asistencia con el ID: " + id));
    }

    @Override
    public List<SolicitudDeAsistencia> obtenerTodasLasSolicitudes() {
        return solicitudDeAsistenciaRepository.findAll();
    }

    @Override
    public List<SolicitudDeAsistencia> obtenerSolicitudesPorEstado(String estado) {
        return null;
    }

    @Override
    public void actualizarSolicitud(SolicitudDeAsistencia solicitud, String nuevoEstado) {
        solicitud.setEstado(nuevoEstado);
        solicitudDeAsistenciaRepository.save(solicitud);
    }

    @Override
    public void eliminarSolicitud(int id) {
        solicitudDeAsistenciaRepository.deleteById(id);
    }



    public boolean enviarSolicitud(SolicitudDeAsistencia solicitud, String message) throws PubNubException {
        solicitudDeAsistenciaRepository.save(solicitud);
        Chat chat = new Chat();
        chat.setMensaje(message);
        chat.setSolicitud(solicitud);
        chat.setUsuario(solicitud.getVoluntario().getUsuario());
        chatService.enviarChat(chat);
        pubNub.publish()
                .channel("solicitudes")
                .message(solicitud.getSolicitudDeAsistenciaId())
                .sync();
        return true;
        // Registar en la base de datos la solicitud en estado pendiente save
        // Enviar a todos los vountarios conectado una solicitud
        // usar el pubnub para el canal de emergencia


    }

    public boolean aceptarSolicitud(Integer solicitudId, Voluntario voluntario) throws PubNubException {

        SolicitudDeAsistencia solicitudDeAsistencia = obtenerSolicitud(solicitudId);
        if (solicitudDeAsistencia == null){
            throw new IllegalArgumentException("Solicitud no encontrada");
        }

        solicitudDeAsistencia.setVoluntario(voluntario);
        solicitudDeAsistencia.setEstado("aceptado");
        solicitudDeAsistenciaRepository.save(solicitudDeAsistencia);

        AdultoMayor adultoMayor = solicitudDeAsistencia.getAdultoMayor();
        if (adultoMayor != null) {
            notificarAdultoMayor(adultoMayor, "Solicitud Aceptada");
        }
        pubNub.publish()
                .channel("chat-" + solicitudId)
                .message("Solicitud Aceptada")
                .sync();
        return true;

        // Buscar la solicitud
        // asignar el Voluntario a la solicitud
        //marcar la solicitud como aceptada
        // notificar al adultoMayor que su solicitud ha sido acpetada

    }

    public void notificarAdultoMayor(AdultoMayor adultoMayor, String mensaje) throws PubNubException {

        pubNub.publish()
                .channel("notificaciones-" + adultoMayor.getIdAdultoMayor())
                .message(mensaje)
                .sync();
    }





}
