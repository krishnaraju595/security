package io.github.hengyunabc.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.hengyunabc.sample.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
