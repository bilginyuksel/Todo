package com.bilginyuksel.todo.endpoint;

import com.bilginyuksel.todo.exception.UserLoginException;
import com.bilginyuksel.todo.model.OAuth;
import com.bilginyuksel.todo.model.Role;
import com.bilginyuksel.todo.model.User;
import com.bilginyuksel.todo.repository.RoleRepository;
import com.bilginyuksel.todo.repository.UserRepository;
import com.bilginyuksel.todo.service.AuthenticationService;
import com.bilginyuksel.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserResource {


    @Autowired private UserService userService;
    @Autowired private AuthenticationService authenticationService;
    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        try{
            String token = userService.login(username, password);
            return "Login Successfull!\n"+token;
        }catch (UserLoginException u){
            return "Username or password wrong!\n"+u.getMessage();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @PostMapping("/logout")
    public String logout(@RequestHeader String Authorization){
        boolean isAuthenticated = authenticationService.isAuthenticated(Authorization);
        if(isAuthenticated) userService.logout(Authorization);
        return isAuthenticated?"Logout Completed!":"You're not logged in.";
    }


    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password,
                         @RequestParam String email){
        // Check if a user exists with the same username.
        User u = new User(username, password, email);
        Optional<Role> optionalRole = roleRepository.findByTitle("USER");
        u.setRole(optionalRole.get());
        userRepository.save(u);
        return u.toString();
    }
}
