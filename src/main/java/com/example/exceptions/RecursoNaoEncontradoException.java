package com.example.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException{
    public RecursoNaoEncontradoException() {
        super("Usuário não encontrado");
    }
}
