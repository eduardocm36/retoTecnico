package com.compartamos.reto_Tecnico.Exceptions;

public class AppException extends Exception{

    private ExceptionDetails details;

    public AppException(String message, ExceptionDetails details) {
        super(message);
        this.details = details;
    }

    public ExceptionDetails getDetails() {
        return details;
    }

    public void setDetails(ExceptionDetails details) {
        this.details = details;
    }
}
