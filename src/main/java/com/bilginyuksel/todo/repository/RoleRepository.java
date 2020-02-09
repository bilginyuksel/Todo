package com.bilginyuksel.todo.repository;

import com.bilginyuksel.todo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByTitle(String title);
}
