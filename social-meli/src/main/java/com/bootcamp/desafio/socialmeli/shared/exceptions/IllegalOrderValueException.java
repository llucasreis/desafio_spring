package com.bootcamp.desafio.socialmeli.shared.exceptions;

public class IllegalOrderValueException extends RuntimeException {

    public IllegalOrderValueException() {
        super("Este valor de ordenação não é válido");
    }
}
