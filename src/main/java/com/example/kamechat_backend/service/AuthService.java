package com.example.kamechat_backend.service;

import com.example.kamechat_backend.entity.User;

import java.util.List;

public interface AuthService {
    User login(User user);

    List<User> getAllUsers(int userId);

    User logout(User user);
}
