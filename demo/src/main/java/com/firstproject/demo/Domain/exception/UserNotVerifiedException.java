package com.firstproject.demo.Domain.exception;

public class UserNotVerifiedException extends RuntimeException {
    public UserNotVerifiedException() {
        super("User account is not verified");
    }
}
