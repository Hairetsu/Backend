package com.conectamayores.seniorconnectapi.exceptions;

public class InvalidCredentialsException extends RuntimeException{

    public InvalidCredentialsException() {
        super("Credenciales inválidas");
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }

    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}
