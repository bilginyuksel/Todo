package com.bilginyuksel.todo.repository;

import com.bilginyuksel.todo.model.Category;
import com.bilginyuksel.todo.model.Todo;
import com.bilginyuksel.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Modifying
    @Query("update Todo t set t.done = true where t.id = ?1")
    void setTodoDoneById(Integer id);

    List<Todo> findAllByUser(User user);
    List<Todo> findAllByUserAndCategory(User user, Category category);
    void deleteTodoByIdAndUser(Integer id, User user);
    Optional<Todo> findTodoByIdAndUser(Integer id, User user);
}
