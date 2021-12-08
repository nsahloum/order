package com.switchfully.order.exceptions;

public class NotUniqException extends RuntimeException{
    public NotUniqException(String message) {
        super(message);
    }
}
