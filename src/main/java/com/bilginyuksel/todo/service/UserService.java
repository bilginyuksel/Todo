package com.bilginyuksel.todo.service;

import com.bilginyuksel.todo.exception.UserLoginException;
import com.bilginyuksel.todo.model.OAuth;
import com.bilginyuksel.todo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


public interface UserService {

    OAuth login(String username, String password) throws UserLoginException;
    void logout(String token);
    User register(String username, String password, String email);
}
