package com.abnamro.exception;

public class PersonCustomException extends RuntimeException {
    private String error;


    public PersonCustomException(String error) {
        super(error);
        this.error = error;
    }
}
