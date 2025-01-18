package com.example.kamechat_backend.controller;

import com.example.kamechat_backend.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class RealtimeController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public RealtimeController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/broadcast-message")
    @SendTo("/broadcast/chat")
    public Message broadcastMessage(Message message) {
        return message;
    }

    @MessageMapping("/unicast-message")
    public void unicastMessage(Message message) {
        simpMessagingTemplate.convertAndSendToUser(
                message.getReceiver().getId().toString(),
                "/chat",
                message
        );
    }
}
