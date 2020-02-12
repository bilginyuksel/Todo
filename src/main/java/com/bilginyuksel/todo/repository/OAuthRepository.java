package com.bilginyuksel.todo.repository;

import com.bilginyuksel.todo.model.OAuth;
import com.bilginyuksel.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OAuthRepository extends JpaRepository<OAuth, Integer> {
    Optional<OAuth> findByToken(String token);

    @Modifying
    @Query("update OAuth set enabled = false where token = ?1")
    // @Query("update OAuth o set o.enabled=false where o.token=?1")
    void setOAuthEnabledFalseByToken(String token);

    Optional<OAuth> findOAuthByUserAndEnabled(User user, boolean enabled);
}
