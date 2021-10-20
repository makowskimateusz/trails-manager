package com.element.trailsmanager.common;

public class TrailAlreadyExistsException extends RuntimeException {
    public TrailAlreadyExistsException(String message) {
        super(message);
    }
}
