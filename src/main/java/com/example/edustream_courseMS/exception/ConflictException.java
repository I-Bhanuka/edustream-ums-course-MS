package com.example.edustream_courseMS.exception;

public class ConflictException extends ApplicationException {
    public ConflictException(String message) {
        super(message, 409);
    }
}
