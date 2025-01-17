package com.example.kamechat_backend.service;

import com.example.kamechat_backend.entity.User;

public interface AuthService {
    User login(User user);
}
