package com.example.kamechat_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    public String fullName;
    @Column(name = "email", unique = true)
    public String email;
    @Column(name = "picture")
    public String picture;
    @Column(name = "status")
    public String status;
}
