package br.com.usuario.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
