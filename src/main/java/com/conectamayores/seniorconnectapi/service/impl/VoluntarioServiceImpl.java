package com.conectamayores.seniorconnectapi.service.impl;


import com.conectamayores.seniorconnectapi.model.SolicitudDeAsistencia;
import com.conectamayores.seniorconnectapi.model.Usuario;
import com.conectamayores.seniorconnectapi.model.Voluntario;
import com.conectamayores.seniorconnectapi.repository.SolicitudDeAsistenciaRepository;
import com.conectamayores.seniorconnectapi.repository.UsuarioRepository;
import com.conectamayores.seniorconnectapi.repository.VoluntarioRepository;
import com.conectamayores.seniorconnectapi.service.IVoluntarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoluntarioServiceImpl implements IVoluntarioService<Voluntario,Integer> {

    @Autowired
    private final VoluntarioRepository voluntarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SolicitudDeAsistenciaRepository solicitudDeAsistenciaRepository;

    @Override
    public Voluntario save(Voluntario voluntario) throws Exception {
        if (voluntario.getUsuario() != null && (voluntario.getUsuario().getIdUsuario() == null || voluntario.getUsuario().getIdUsuario() == 0)) {
            usuarioRepository.save(voluntario.getUsuario());
        }
        return voluntarioRepository.save(voluntario);
    }

    @Override
    public Voluntario update(Voluntario voluntario, Integer id) throws Exception {
        Voluntario existingVoluntario = voluntarioRepository.findById(id)
                .orElseThrow(() -> new Exception("Voluntario no encontrado con ID: " + id));

        // Actualizar los campos del voluntario existente
        existingVoluntario.setNombreCompleto(voluntario.getNombreCompleto());
        existingVoluntario.setEdad(voluntario.getEdad());
        existingVoluntario.setGustos(voluntario.getGustos());
        existingVoluntario.setGenero(voluntario.getGenero());

        // Guardar los cambios en el repositorio

        return voluntarioRepository.save(existingVoluntario);
    }

    @Override
    public List<Voluntario> readAll() {
        return null;
    }

    @Override
    public Voluntario readById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {

    }
    @Override
    public Voluntario crearVoluntario(Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    @Override
    public Voluntario obtenerVoluntarioPorId(Integer id) {
        return null;
    }

    @Override
    public List<Voluntario> obtenerTodosLosVoluntarios() {
        return voluntarioRepository.findAll();
    }

    @Override
    public void eliminarVoluntario(Integer id) {
        voluntarioRepository.deleteById(id);
    }

    @Override
    public Voluntario actualizarVoluntario(Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    @Override
    public List<Voluntario> buscarVoluntario(String nombre) {


        // Realiza la búsqueda de voluntarios por nombre
        List<Voluntario> listaVoluntarios = voluntarioRepository.buscarNombre(nombre);

        // Verifica si se encontraron voluntarios
        if (listaVoluntarios.isEmpty()) {
            throw new NoSuchElementException("No se encontraron voluntarios con el nombre " + nombre);
        }

        // Devuelve la lista de voluntarios encontrados
        return listaVoluntarios;

    }


    public boolean estaDisponible(Voluntario voluntario) {
        // Buscar el voluntario en la base de datos usando el ID
        Usuario voluntarioEncontrado = usuarioRepository.findById(voluntario.getIdVoluntario())
                .orElseThrow(() -> new RuntimeException("Voluntario no encontrado"));

        // Comprobar la disponibilidad del voluntario
        return voluntarioEncontrado.isEstado();  // Asume que tienes un método getEstaDisponible en tu clase Voluntario
    }


    public Voluntario obtenerPorId(Integer voluntarioId) {
        return voluntarioRepository.findById(voluntarioId)
                .orElseThrow(() -> new RuntimeException("No se encontró al adulto mayor con el ID: " + voluntarioId));
    }

    public boolean enviarSolicitud(SolicitudDeAsistencia solicitud) {
        solicitud.setEstado("Pendiente");
        if (estaDisponible(solicitud.getVoluntario())) {
            // Envío de la solicitud al voluntario
            boolean enviado = enviarSolicitudAlVoluntario(solicitud);

            if (enviado) {
                // Guardar la solicitud en la base de datos
                solicitudDeAsistenciaRepository.save(solicitud);

                return true; // Solicitud enviada con éxito
            } else {
                return false; // Error al enviar la solicitud al voluntario
            }
        } else {
            return false; // El voluntario seleccionado no está disponible
        }

    }


    private boolean enviarSolicitudAlVoluntario(SolicitudDeAsistencia solicitud) {

        return true;
    }


}

