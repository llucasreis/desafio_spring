package com.bootcamp.desafio.socialmeli.shared.errors;

public class ErrorDTO<T> {
    private T error;

    public ErrorDTO() {
    }

    public ErrorDTO(T error) {
        this.error = error;
    }

    public T getError() {
        return error;
    }

    public void setError(T error) {
        this.error = error;
    }
}
