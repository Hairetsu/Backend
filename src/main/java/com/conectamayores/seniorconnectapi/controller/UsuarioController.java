package com.conectamayores.seniorconnectapi.controller;



import com.conectamayores.seniorconnectapi.config.UsuarioMapper;
import com.conectamayores.seniorconnectapi.dto.CambioContraRequest;
import com.conectamayores.seniorconnectapi.dto.LoginDTO;
import com.conectamayores.seniorconnectapi.dto.UsuarioDTO;
import com.conectamayores.seniorconnectapi.exceptions.*;
import com.conectamayores.seniorconnectapi.model.Usuario;

import com.conectamayores.seniorconnectapi.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO dto) {

        try {
            Usuario user = UsuarioMapper.dtoToEntity(dto); // Mapeo de DTO a entidad

            // Verificar si el usuario ya existe
            if (usuarioService.existsByNombreUsuario(user.getNombreUsuario())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre de usuario: " + dto.getNombreUsuario() + ", ya está registrado");
            }

            Usuario nuevoUsuario = usuarioService.save(user); // Guardar usuario

            UsuarioDTO createUserDTO = UsuarioMapper.entityToDto(nuevoUsuario); // Mapeo de entidad a DTO

            return ResponseEntity.status(HttpStatus.CREATED).body(createUserDTO); // Retornar usuario creado con estatus 201

        } catch (Exception e) { // En caso de otros errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el usuario");
        }


    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarioList = usuarioService.findAll();
        return new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }

    @PutMapping("/{username}/change-password")
    public ResponseEntity<String> cambiarContra(@PathVariable String username, @RequestBody CambioContraRequest request) {
        try {
            usuarioService.cambiarClave(username, request.getContraActual(), request.getNuevaContra());
            return ResponseEntity.ok("Contraseña cambiada con éxito");
        } catch (UsuarioNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario no existe" );
        } catch (ContraInvalidaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La contraseña actual es incorrecta " );
        } catch (ContraIgualException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La nueva contraseña no puede ser igual a la actual ");
        }
    }

    @PutMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UsuarioDTO request){
        try {
            usuarioService.loginUser(request.getNombreUsuario(), request.getClave());
            return ResponseEntity.ok("Login exitoso");
        }catch (UsuarioNoEncontradoException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("El usuario no existe");
        }catch(ContraIncorrectaException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta" );
        }
    }

    @ExceptionHandler(UsuarioExistenteException.class)
    public ResponseEntity<String> handleUsuarioExistenteException(UsuarioExistenteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}











