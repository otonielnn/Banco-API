package me.dio.santander_backend2024.service;

import me.dio.santander_backend2024.model.User;

public interface UserService {
    User FindById(Long id);

    User create(User userToCreate);
}
