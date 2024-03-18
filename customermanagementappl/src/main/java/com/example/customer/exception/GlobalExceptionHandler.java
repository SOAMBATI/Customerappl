package com.example.customer.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ServerDownException.class})
    public ResponseEntity<Object> handleServerDownException(ServerDownException ex) {
        // Log the exception
        // You can also use AOP for logging
        
        return new ResponseEntity<>("Server is currently down. Please try again later.",
                HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(value = {CustomerNotFoundException.class})
    public ResponseEntity<Object> handleItemNotFoundException(CustomerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

