package com.firstproject.demo.Domain.exception;

public class UserNotActiveException extends RuntimeException {
    public UserNotActiveException() {
        super("User account is not active");
    }
}
