package com.example.kamechat_backend.service;

import com.example.kamechat_backend.entity.User;
import com.example.kamechat_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(User user) {
        User fromDb = userRepository.findByEmail(user.getEmail());
        if(fromDb != null) return fromDb;
        return userRepository.save(user);
    }
}
