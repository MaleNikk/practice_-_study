package com.example.exception;

public class AppBotException extends RuntimeException {
    public AppBotException(String message, Throwable cause) {
        super(message, cause);
    }
}
