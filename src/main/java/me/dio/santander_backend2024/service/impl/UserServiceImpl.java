package me.dio.santander_backend2024.service.impl;

import org.springframework.stereotype.Service;

import me.dio.santander_backend2024.domain.model.User;
import me.dio.santander_backend2024.domain.repository.UserRepository;
import me.dio.santander_backend2024.service.UserService;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User FindById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account Number already exists.");
        }
        return userRepository.save(userToCreate);
    }
    
}
