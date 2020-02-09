package com.bilginyuksel.todo.exception;

public class PasswordMatchException extends UserLoginException {
    @Override
    public String getMessage() {
        return "Password!";
    }
}
