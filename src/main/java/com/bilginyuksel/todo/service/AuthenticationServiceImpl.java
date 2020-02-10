package com.bilginyuksel.todo.service;

import com.bilginyuksel.todo.exception.UserAuthenticationTokenException;
import com.bilginyuksel.todo.exception.UserNoAuthenticationToken;
import com.bilginyuksel.todo.exception.UserNotEnabledAuthenticationToken;
import com.bilginyuksel.todo.repository.OAuthRepository;
import com.bilginyuksel.todo.model.OAuth;
import com.bilginyuksel.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    @Autowired
    private OAuthRepository authRepository;

    @Override
    public OAuth createAuthenticationTokenToUser(User user) {

        OAuth oAuth = new OAuth(user);
        authRepository.save(oAuth);
        return oAuth;
    }


    @Override
    public boolean isAuthenticated(String token) {

        Optional<OAuth> optionalOAuth = authRepository.findByToken(token);
        if (optionalOAuth.isPresent() && optionalOAuth.get().isEnabled()) return true;

        return false;
    }

    @Override
    public User findAlreadyLoggedUser(String token) throws UserAuthenticationTokenException {

        Optional<OAuth> optionalOAuth = authRepository.findByToken(token);
        if(!optionalOAuth.isPresent()) throw new UserNoAuthenticationToken();

        if(!optionalOAuth.get().isEnabled()) throw new UserNotEnabledAuthenticationToken();

        // if(!optionalOAuth.get().getExpireDate().before(new Date()))
        // Expired authentication token.

        return optionalOAuth.get().getUser();
    }
}
