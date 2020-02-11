package com.bilginyuksel.todo.User;

import com.bilginyuksel.todo.model.User;
import com.bilginyuksel.todo.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRegisterationTests {

    @Autowired private UserService userService;

    @Test
    void userRegisterationWithRightCredentials(){
        User user = userService.register("test","tset","test@testmail.com");
        Assert.assertNotNull(user);
        System.out.println("User = "+user);
    }

    @Test
    void userRegisterationWithTheSameEmailAdress(){
        User user = userService.register("bilginyuksel","123456","bilgin.yuksel96@gmail.com");
        Assert.assertNull(user);
        System.out.println("User = "+user);
    }

    @Test
    void userRegisterationWithTheSameUsername(){
        User user = userService.register("bilginyuksel","123456","bilgin.yuksel96@gmail.com");
        Assert.assertNull(user);
        System.out.println("User = "+user);
    }
}
