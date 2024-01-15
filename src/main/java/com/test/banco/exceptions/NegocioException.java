package com.test.banco.exceptions;
public class NegocioException extends RuntimeException {
    public NegocioException(String mensagem){
        super(mensagem);
    }
}
