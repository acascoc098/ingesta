package com.iesvdc.acceso.app.servicios;

public class ExcDAO extends RuntimeException {
    public ExcDAO(String message) {
        super(message);
    }

    public ExcDAO(String message, Throwable cause) {
        super(message, cause);
    }
}
