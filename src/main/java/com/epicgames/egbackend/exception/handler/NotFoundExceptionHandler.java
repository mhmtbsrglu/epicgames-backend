package com.epicgames.egbackend.exception.handler;

import com.epicgames.egbackend.core.exception.ExceptionResponse;
import com.epicgames.egbackend.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class NotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> notFoundException(NotFoundException exception, WebRequest request){
        return new ResponseEntity<ExceptionResponse>(ExceptionResponse.builder()
                .message(exception.getMessage())
                .dateTime(LocalDateTime.now())
                .build(),HttpStatus.NOT_FOUND);
    }
}
