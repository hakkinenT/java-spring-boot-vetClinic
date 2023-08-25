package com.hakkinenT.vetClinic.controllers.handlers;

import com.hakkinenT.vetClinic.dto.errors.CustomError;
import com.hakkinenT.vetClinic.dto.errors.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados Inválidos", request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            String field = f.getField();

            if (field.contains(".")) {
                field = getLastField(field);
            }

            err.addError(field, f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }

    private String getLastField(String field) {
        String[] aux = field.replace(".", " ").split(" ");
        int index = aux.length - 1;
        return aux[index];
    }
}
