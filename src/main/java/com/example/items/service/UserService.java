package com.example.items.service;

import com.example.items.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String login);
    List<User> getUsers();
}
