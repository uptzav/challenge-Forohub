package com.foro.forohub.domain;

public class ValidacionExcepcion extends RuntimeException{

    public ValidacionExcepcion(String mensaje) {
        super(mensaje);
    }

}
