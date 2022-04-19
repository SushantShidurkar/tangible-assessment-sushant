package com.abnamro.assessment.exception;

public class PersonCustomException extends RuntimeException {
    private String error;


    public PersonCustomException(String error) {
        super(error);
        this.error = error;
    }
}
