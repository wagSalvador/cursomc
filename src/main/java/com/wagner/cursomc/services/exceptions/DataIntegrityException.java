package com.wagner.cursomc.services.exceptions;

public class DataIntegrityException extends RuntimeException {

    public DataIntegrityException(String mensagem) {
        super(mensagem);
    }

    public DataIntegrityException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
