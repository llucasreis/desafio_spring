package com.bootcamp.desafio.socialmeli.shared.handlers;

import com.bootcamp.desafio.socialmeli.shared.errors.ErrorDTO;
import com.bootcamp.desafio.socialmeli.shared.errors.ErrorFieldDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class MethodArgumentNotValidHandler {

    private final MessageSource messageSource;

    @Autowired
    public MethodArgumentNotValidHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }



    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO<List<ErrorFieldDTO>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<ErrorFieldDTO> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorFieldDTO error = new ErrorFieldDTO(e.getField(), message);
            errors.add(error);
        });

        return new ErrorDTO<>(errors);
    }
}
