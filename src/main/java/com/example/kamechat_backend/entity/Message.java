package com.example.kamechat_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sender_id")
    private User sender;
    @Column(name = "receiver_id")
    private User receiver;
    @Column(name = "original_message")
    private String originalMessage;
    @Column(name = "translated_message")
    private String translatedMessage;
}
