package com.bootcamp.desafio.socialmeli.shared.handlers;

import com.bootcamp.desafio.socialmeli.shared.errors.ErrorDTO;
import com.bootcamp.desafio.socialmeli.shared.errors.ErrorFieldDTO;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidFormatHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidFormatException.class)
    public ErrorDTO<ErrorFieldDTO> handleInvalidFormatException(InvalidFormatException exception) {
        String field = exception.getPath().get(0).getFieldName();
        String message = "Valor " + exception.getValue() + " não é válido para o campo";

        ErrorFieldDTO error = new ErrorFieldDTO(field, message);

        return new ErrorDTO<>(error);
    }
}
