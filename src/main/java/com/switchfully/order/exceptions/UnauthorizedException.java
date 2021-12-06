package com.switchfully.order.exceptions;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException() {
        this("You are not authorized to access this page");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
