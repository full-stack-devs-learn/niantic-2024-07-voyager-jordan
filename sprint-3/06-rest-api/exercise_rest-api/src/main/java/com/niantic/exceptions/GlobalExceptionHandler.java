package com.niantic.exceptions;

import com.niantic.models.HttpError;
import com.niantic.services.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    LoggingService errorLog = new LoggingService("errors");

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HttpError> handleNotFound(ResourceNotFoundException e)
    {
        errorLog.logMessage(e.getMessage());
        var error = new HttpError(HttpStatus.NOT_FOUND.value()
                , HttpStatus.NOT_FOUND.toString()
                , String.format("%s %s couldn't be found", e.getResourceType(), e.getSearched()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    };

    public ResponseEntity<HttpError> handleInternalServerError(Exception e)
    {
        errorLog.logMessage(e.getMessage());
        var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value()
                , HttpStatus.INTERNAL_SERVER_ERROR.toString()
                , "Oops! Something went wrong on our end. Please try again later.");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    };
}
