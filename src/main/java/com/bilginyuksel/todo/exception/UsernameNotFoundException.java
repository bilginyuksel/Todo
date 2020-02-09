package com.bilginyuksel.todo.exception;

public class UsernameNotFoundException extends UserLoginException {

    @Override
    public String getMessage() {
        return "username";
    }
}
