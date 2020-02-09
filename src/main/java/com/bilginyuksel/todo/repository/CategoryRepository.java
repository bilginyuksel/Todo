package com.bilginyuksel.todo.repository;

import com.bilginyuksel.todo.model.Category;
import com.bilginyuksel.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAllByUser(User user);
}
