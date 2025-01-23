package com.example.kamechat_backend.controller;

import com.example.kamechat_backend.entity.User;
import com.example.kamechat_backend.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return authService.login(user);
    }

    @PostMapping("/logout")
    public User logout(@RequestBody User user) {
        return authService.logout(user);
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers(@RequestParam("userId") int userId) {
        return authService.getAllUsers(userId);
    }
}
