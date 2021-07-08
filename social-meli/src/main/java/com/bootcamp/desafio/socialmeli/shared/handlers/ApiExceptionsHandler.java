package com.bootcamp.desafio.socialmeli.shared.handlers;

import com.bootcamp.desafio.socialmeli.shared.errors.ErrorDTO;
import com.bootcamp.desafio.socialmeli.shared.exceptions.BadRequestException;
import com.bootcamp.desafio.socialmeli.shared.exceptions.IllegalOrderValueException;
import com.bootcamp.desafio.socialmeli.shared.exceptions.NotFoundException;
import com.bootcamp.desafio.socialmeli.shared.exceptions.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionsHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException exception) {
        return ResponseEntity.badRequest().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalOrderValueException.class)
    public ErrorDTO<String> handleIllegalOrderValueException(IllegalOrderValueException exception) {
        return new ErrorDTO<>(exception.getMessage());
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorDTO<String> handleNotFoundException(NotFoundException exception) {
        return new ErrorDTO<>(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictException.class)
    public ErrorDTO<String> handleConflictException(ConflictException exception) {
        return new ErrorDTO<>(exception.getMessage());
    }
}
