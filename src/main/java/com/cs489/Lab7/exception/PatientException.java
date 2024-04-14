package com.cs489.Lab7.exception;

import com.cs489.Lab7.exception.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PatientException {
    @ExceptionHandler(PatientNotException.class)
    public ErrorResponse patientNotFoundHandler(PatientNotException exception) {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                exception.getMessage()
        );
    }
}
