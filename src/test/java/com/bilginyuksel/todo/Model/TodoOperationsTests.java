package com.bilginyuksel.todo.Model;

import com.bilginyuksel.todo.Preparation.TestPreperationManager;
import com.bilginyuksel.todo.Preparation.TestPreperationManagerImpl;
import com.bilginyuksel.todo.Preparation.UserTestPreparation;
import com.bilginyuksel.todo.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoOperationsTests {

    protected UserTestPreparation userTestPreparation;
    private TestPreperationManager preperationManager;
    private ModelOperations<Todo> todoModelOperations;

    public TodoOperationsTests(){
        preperationManager = new TestPreperationManagerImpl();
        todoModelOperations = new ModelOperationsImpl();
    }

    @Test
    void prepareTodoTestForOneUser(){
        userTestPreparation = new UserTestPreparation();
        userTestPreparation.setUser1(null);
    }

    @Test
    void insertTodo(){

        Todo todo1 = new Todo("title","content");
        todo1.setUser(userTestPreparation.getUser1());

        Todo todo2 = new Todo("content");
        todo2.setUser(userTestPreparation.getUser1());

    }

    @Test
    void updateTodo(){
    }

    @Test
    void deleteTodo(){

    }

    @Test
    void findTodoById(){

    }

    @Test
    void findTodoByWrongId(){

    }
}
