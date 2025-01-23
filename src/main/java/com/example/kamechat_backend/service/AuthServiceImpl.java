package com.example.kamechat_backend.service;

import com.example.kamechat_backend.entity.User;
import com.example.kamechat_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(User user) {
        user.setStatus("online");
        User fromDb = userRepository.findByEmail(user.getEmail());
        if(fromDb == null) {
            user.setFullName(reformatFullName(user.getFullName()));
            return userRepository.save(user);
        }
        fromDb.setStatus("online");
        return userRepository.save(fromDb);
    }

    public String reformatFullName(String fullName) {
        String[] names = fullName.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(names[0])
                .append(" ")
                .append(names[1]);
        return sb.toString().trim();
    }

    @Override
    public List<User> getAllUsers(int userId) {
        return userRepository.findAllByIdNot(userId);
    }

    @Override
    public User logout(User user) {
        User fromDb = userRepository.findByEmail(user.getEmail());
        if(fromDb == null) {
            return null;
        }
        fromDb.setStatus("offline");
        return userRepository.save(fromDb);
    }
}
