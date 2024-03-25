package com.compartamos.reto_Tecnico.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionController.class.getName());

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ExceptionDetails> handVoucherException(AppException exception){
        LOG.error(exception.getMessage());
        return new ResponseEntity<>(exception.getDetails(), HttpStatus.valueOf(exception.getDetails().getCode()));
    }
}
