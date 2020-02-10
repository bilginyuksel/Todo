package com.bilginyuksel.todo.repository;

import com.bilginyuksel.todo.model.ShareTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShareTodoRepository extends JpaRepository<ShareTodo, Integer> {
    Optional<ShareTodo> findShareTodoByToken(String token);
}
