package com.bilginyuksel.todo.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class ModelOperationsImpl<T> implements ModelOperations<T> {
    @Override
    public void saveEntity(JpaRepository repository, T obj) {

    }

    @Override
    public Optional<T> findModelById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteEntityById(Integer id) {

    }
}
