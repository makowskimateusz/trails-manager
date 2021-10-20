package com.element.trailsmanager.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ErrorMessage> handleNotFoundException(NotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, NOT_FOUND);
    }

    @ExceptionHandler(TrailAlreadyExistsException.class)
    ResponseEntity<ErrorMessage> handleAlreadyExistsException(TrailAlreadyExistsException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, BAD_REQUEST);
    }

    @Getter
    @AllArgsConstructor
    class ErrorMessage {
        private String message;
        private String details;

        public ErrorMessage(String message) {
            this.message = message;
        }
    }
}
