package com.wagner.cursomc.resources.exception;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Integer status, String mensagem, LocalDate timeStamp) {
        super(status, mensagem, timeStamp);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String message) {
        erros.add(new FieldMessage(fieldName, message));
    }
}
