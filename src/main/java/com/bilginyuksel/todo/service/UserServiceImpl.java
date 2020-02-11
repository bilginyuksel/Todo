package com.bilginyuksel.todo.service;

import com.bilginyuksel.todo.model.OAuth;
import com.bilginyuksel.todo.repository.OAuthRepository;
import com.bilginyuksel.todo.repository.UserRepository;
import com.bilginyuksel.todo.exception.PasswordMatchException;
import com.bilginyuksel.todo.exception.UserLoginException;
import com.bilginyuksel.todo.exception.UsernameNotFoundException;
import com.bilginyuksel.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private OAuthRepository authRepository;

    @Override
    public String login(String username, String password) throws UserLoginException {

        Optional<User> optionalUser = userRepository.findUserByUsername(username);

        if(!optionalUser.isPresent())
            throw new UsernameNotFoundException();
        User user = optionalUser.get();
        if (!user.getPassword().equals(password)) throw new PasswordMatchException();

        // Check if user is already logged in or not.
        // If user has the token so return the old token don't create a new one.
        // Or print a message u're already logged in.
        Optional<OAuth> optionalOAuth = authRepository.findOAuthByUserAndEnabled(user, true);
        if(optionalOAuth.isPresent() && optionalOAuth.get().isEnabled() /*also date check*/)
            return optionalOAuth.get().getToken();

        OAuth token = authenticationService.createAuthenticationTokenToUser(optionalUser.get());

        return token.getToken();
    }



    @Override
    public void logout(String token) {
        authRepository.setOAuthEnabledFalseByToken(token);
    }

    @Override
    public User register(String username, String password, String email) {

        Optional<User> optionalUserUsername = userRepository.findUserByUsername(username);
        Optional<User> optionalUserEmail = userRepository.findUserByEmail(email);
        if(!optionalUserEmail.isPresent() && !optionalUserUsername.isPresent()){
            User user = new User(username, password, email);
            userRepository.save(user);
            return user;
        }

        return null;
    }
}
