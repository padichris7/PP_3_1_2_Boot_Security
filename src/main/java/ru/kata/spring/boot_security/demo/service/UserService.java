package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Long id);
    User findUserByUsername(String username);
    void createUser (User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
    boolean existsByUsername(String username);
}
