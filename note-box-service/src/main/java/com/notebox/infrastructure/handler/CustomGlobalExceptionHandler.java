package com.notebox.infrastructure.handler;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex){
        log.info(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(prepareResponseMap(ex, HttpStatus.BAD_REQUEST));
    }

    private Map prepareResponseMap(ConstraintViolationException e, HttpStatus httpStatus){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp",LocalDateTime.now());
        body.put("status", httpStatus.value());
        List<FieldError> errors = new ArrayList<>();
        if(e instanceof ConstraintViolationException){
            errors = e.getConstraintViolations().stream()
                    .map(constraintViolation -> new FieldError(constraintViolation.getRootBeanClass().getName()
                            , constraintViolation.getPropertyPath().toString()
                            , constraintViolation.getMessage()))
                    .collect(Collectors.toList());
        }
        body.put("errors", errors);
        return body;
    }


}
