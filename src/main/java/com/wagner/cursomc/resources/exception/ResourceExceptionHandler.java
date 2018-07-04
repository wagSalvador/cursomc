package com.wagner.cursomc.resources.exception;

import com.wagner.cursomc.services.exceptions.DataIntegrityException;
import com.wagner.cursomc.services.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDate;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDate.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), LocalDate.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação", LocalDate.now());
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            validationError.addError(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }
}
