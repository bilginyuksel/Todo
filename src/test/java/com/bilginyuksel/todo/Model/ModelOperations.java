package com.bilginyuksel.todo.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelOperations<T> {
    void saveEntity(JpaRepository repository, T obj);
    Optional<T> findModelById(Integer id);
    void deleteEntityById(Integer id);
}
