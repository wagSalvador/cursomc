package com.wagner.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String mensagem) {
        super(mensagem);
    }

    public ObjectNotFoundException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
