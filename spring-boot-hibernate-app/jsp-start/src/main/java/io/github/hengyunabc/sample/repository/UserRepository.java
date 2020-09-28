package io.github.hengyunabc.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.hengyunabc.sample.model.Employee;

public interface UserRepository extends JpaRepository<Employee, Long> {
    Employee findByUsername(String username);
}
