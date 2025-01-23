package com.example.kamechat_backend.service;

import com.example.kamechat_backend.entity.Message;
import com.example.kamechat_backend.entity.User;
import com.example.kamechat_backend.repository.MessageRepository;
import com.example.kamechat_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public ChatServiceImpl(MessageRepository messageRepository,
                           UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public Message saveMessage(Message message) {
        User sender = userRepository.findByEmail(message.getSender().getEmail());
        User receiver = userRepository.findByEmail(message.getReceiver().getEmail());
        message.setSender(sender);
        message.setReceiver(receiver);
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getAllMessages(String chatId) {
        return messageRepository.findAllByChatIdOrderByTimestampAsc(chatId);
    }
}
