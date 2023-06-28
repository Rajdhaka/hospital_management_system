package com.geekster.hospital_management_system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class IllegalStateExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleIllegalStateException(Exception ex) {
        Map<String, String> errorObj = new HashMap<>();

        String error = "error";
        String httpErrorStatus = HttpStatus.INTERNAL_SERVER_ERROR.toString().replace("_", " ");

        errorObj.put(error, httpErrorStatus);

        String exception = "exception";
        String exceptionName = ex.getClass().getSimpleName();

        errorObj.put(exception, exceptionName);

        String message = "message";
        String localizedMessage = ex.getLocalizedMessage();

        errorObj.put(message, localizedMessage);

        return new ResponseEntity<Map<String, String>>(errorObj,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
