package com.fmatheus.app.controller.exception;

import java.io.Serial;


public class JasperException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public JasperException(String message) {
        super(message);
    }

}
