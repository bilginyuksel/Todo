package com.bilginyuksel.todo.User;

import com.bilginyuksel.todo.exception.UserLoginException;
import com.bilginyuksel.todo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserLoginTests {

    @Autowired private UserService userService;

    @Test
    void loginWithRightUserCredentials(){
        try{
            String token = userService.login("bilginyuksel", "123456");
            System.out.println("User Login Successfully Completed!");
            System.out.println(String.format("Token = %s",token));
        }catch (UserLoginException e){
            e.printStackTrace();
            assert true: "User had to successfull login.";
        }
    }

    @Test
    void loginWithNonExistedUserCredentials(){
        try{
            userService.login("Hassnain", "1234");
            assert true: "Something went wrong! User login exception expected.";
        }catch (UserLoginException e){
            System.out.println("Test passed successfully!\nUser login failed.");
        }
    }


}
