package com.epicgames.egbackend.exception;

import com.epicgames.egbackend.core.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GeneralException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> methodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception){
        return new ResponseEntity<ExceptionResponse>(ExceptionResponse.builder()
                .message("Failed to convert value of type...")
                .dateTime(LocalDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }
}
