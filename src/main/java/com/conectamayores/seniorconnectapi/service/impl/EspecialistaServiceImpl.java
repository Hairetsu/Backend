package com.conectamayores.seniorconnectapi.service.impl;


import com.conectamayores.seniorconnectapi.model.Especialista;
import com.conectamayores.seniorconnectapi.repository.EspecialistaRepository;
import com.conectamayores.seniorconnectapi.repository.UsuarioRepository;
import com.conectamayores.seniorconnectapi.service.IEspecialista;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EspecialistaServiceImpl  implements IEspecialista<Especialista, Integer>{

    private final EspecialistaRepository especialistaRepository;
    private final UsuarioRepository usuarioRepository;


    @Override
    public Especialista save(Especialista especialista) {
        return  especialistaRepository.save(especialista);
    }

    public Especialista findById(Integer id) {
        return especialistaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Especialista no encontrado"));

    }


    @Override
    public List<Especialista> findAll() {
        return especialistaRepository.findAll();

    }

    @Override
    public void delete(Integer id) {
        especialistaRepository.deleteById(id);
    }

    public Especialista updateEspecialista(Especialista especialista, Integer id) throws Exception {

        Optional<Especialista> optionalEspecialista = especialistaRepository.findById(id);
        if (optionalEspecialista.isPresent()) {
            Especialista existingEspecialista = optionalEspecialista.get();
            existingEspecialista.setNombre(especialista.getNombre());
            existingEspecialista.setEspecialidad(especialista.getEspecialidad());
            // Actualizar otros campos según sea necesario

            return especialistaRepository.save(existingEspecialista);
        } else {
            throw new Exception("Especialista no econtrado con esa id: " + id);
        }
    }

    public Especialista createEspecialista(Especialista especialista) {
        if (especialista.getUsuario() != null && (especialista.getUsuario().getIdUsuario() == null || especialista.getUsuario().getIdUsuario() == 0)) {
            usuarioRepository.save(especialista.getUsuario());
        }
        return especialistaRepository.save(especialista);

    }

    public Especialista getEspecialistaById(Integer id) {
        Optional<Especialista> optionalEspecialista = especialistaRepository.findById(id);
        return optionalEspecialista.orElse(null);
    }
}
