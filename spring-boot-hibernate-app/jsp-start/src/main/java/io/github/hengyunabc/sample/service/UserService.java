package io.github.hengyunabc.sample.service;

import io.github.hengyunabc.sample.model.Employee;

public interface UserService {
    void save(Employee employee);

    Employee findByUsername(String username);
}
