package br.com.usuario.service.exceptions;

public class DataIntegratyViolationException extends RuntimeException{

    public DataIntegratyViolationException(String msg) {
        super(msg);
    }
}
