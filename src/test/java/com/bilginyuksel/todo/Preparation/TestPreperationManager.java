package com.bilginyuksel.todo.Preparation;

import com.bilginyuksel.todo.model.Category;
import com.bilginyuksel.todo.model.Todo;
import com.bilginyuksel.todo.repository.CategoryRepository;
import com.bilginyuksel.todo.repository.TodoRepository;
import com.bilginyuksel.todo.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestPreperationManager {

    /*
    * Save created user in user test preparation object
    * to database.
    * */
    void registerUsersToApplication(UserService service, UserTestPreparation userTestPreparation);

    void saveEntityToApplication(JpaRepository repository, Object obj);

}
