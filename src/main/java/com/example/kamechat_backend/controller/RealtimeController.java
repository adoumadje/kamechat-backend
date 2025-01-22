package com.example.kamechat_backend.controller;

import com.example.kamechat_backend.entity.Message;
import com.example.kamechat_backend.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class RealtimeController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatService chatService;

    public RealtimeController(SimpMessagingTemplate simpMessagingTemplate,
                              ChatService chatService) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.chatService = chatService;
    }

    @MessageMapping("/broadcast-message")
    @SendTo("/broadcast/chat")
    public Message broadcastMessage(Message message) {
        return message;
    }

    @MessageMapping("/unicast-message")
    public void unicastMessage(Message message) {
        chatService.saveMessage(message);
        simpMessagingTemplate.convertAndSendToUser(
                message.getReceiver().getId().toString(),
                "/chat",
                message
        );
    }
}
