package com.example.kamechat_backend.service;

import com.example.kamechat_backend.entity.Message;

import java.util.List;

public interface ChatService {
    Message saveMessage(Message message);

    List<Message> getAllMessages(String chatId);
}
