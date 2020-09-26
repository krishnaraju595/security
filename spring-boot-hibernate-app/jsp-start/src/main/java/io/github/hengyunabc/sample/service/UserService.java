package io.github.hengyunabc.sample.service;

import io.github.hengyunabc.sample.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
