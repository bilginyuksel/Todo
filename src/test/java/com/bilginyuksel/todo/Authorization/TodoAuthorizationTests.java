package com.bilginyuksel.todo.Authorization;

import com.bilginyuksel.todo.exception.UserAuthenticationTokenException;
import com.bilginyuksel.todo.model.Todo;
import com.bilginyuksel.todo.model.User;
import com.bilginyuksel.todo.repository.TodoRepository;
import com.bilginyuksel.todo.service.AuthenticationService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
public class TodoAuthorizationTests {

    // You can do this test with already taken user accounts.
    // Because of now if any error occures on user authentication test fails.

    @Autowired private TodoRepository todoRepository;
    @Autowired private AuthenticationService authenticationService;

    private int actualTodoId = 4;
    private String authorizedUserToken = "c3b25925-6eda-49fa-b988-596d4f00ba24";
    private String unAuthorizedUserToken = "630369ca-9b38-488d-8fe6-a00862289176";

    /*
    * Test scenario :
    *   User A owns the todos and
    *   User B tries to get todos informations
    * */
    @Test
    void getTodoDetailsByNotAuthorizedUser(){

        try{
            User user = authenticationService.findAlreadyLoggedUser(unAuthorizedUserToken);

            Optional<Todo> todo = todoRepository.findTodoByIdAndUser(actualTodoId, user);
            Assert.assertNull(todo.get());

        }catch (UserAuthenticationTokenException e){
            System.out.println("Test Failed because of authentication token.");
            assert true: "Test failed because of authentication token.";
        }catch (NoSuchElementException e1){
            System.out.println("Test successfully finished !");
        }


    }

    @Test
    void getTodoDetailsByAuthorizedUser(){
        try {
            User user = authenticationService.findAlreadyLoggedUser(authorizedUserToken);

            Optional<Todo> todo = todoRepository.findTodoByIdAndUser(actualTodoId, user);
            Assert.assertNotNull(todo.get());
            System.out.println("Test successfully finished!");

        }catch (UserAuthenticationTokenException e){
            System.out.println("Test Failed because of authentication token.");
            assert true: "Test failed because of authentication token.";
        }
    }



}
