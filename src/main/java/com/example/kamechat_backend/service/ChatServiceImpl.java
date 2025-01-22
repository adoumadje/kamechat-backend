package com.example.kamechat_backend.service;

import com.example.kamechat_backend.entity.Message;
import com.example.kamechat_backend.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private final MessageRepository messageRepository;

    public ChatServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> getAllMessages(String chatId) {
        return messageRepository.findAllByChatIdOrderByTimestampAsc(chatId);
    }
}
