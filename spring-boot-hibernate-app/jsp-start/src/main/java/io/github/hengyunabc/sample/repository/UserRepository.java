package io.github.hengyunabc.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.hengyunabc.sample.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
