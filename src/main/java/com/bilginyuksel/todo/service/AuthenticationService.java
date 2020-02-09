package com.bilginyuksel.todo.service;

import com.bilginyuksel.todo.exception.UserAuthenticationTokenException;
import com.bilginyuksel.todo.model.OAuth;
import com.bilginyuksel.todo.model.User;

public interface AuthenticationService {

    OAuth createAuthenticationTokenToUser(User user);
    // String authenticate(String username, String password);
    boolean isAuthenticated(String token);

    User findAlreadyLoggedUser(String token) throws UserAuthenticationTokenException;
}
