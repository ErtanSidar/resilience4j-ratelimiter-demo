package com.essoft.ratelimiter.exception;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<String> handle(RequestNotPermitted requestNotPermitted) {
        return new ResponseEntity<>("You can make up to 3 requests in 1 minute! \n"
                + requestNotPermitted.getMessage(), HttpStatus.TOO_MANY_REQUESTS);
    }
}
