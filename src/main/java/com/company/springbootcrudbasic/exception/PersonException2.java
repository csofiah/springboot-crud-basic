package com.company.springbootcrudbasic.exception;

public class PersonException2 extends RuntimeException {

    public PersonException2(String message) {
        super(message);
    }

    public PersonException2(String message, Throwable cause) {
        super(message, cause);
    }
}
