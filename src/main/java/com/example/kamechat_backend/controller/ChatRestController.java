package com.example.kamechat_backend.controller;

import com.example.kamechat_backend.entity.Message;
import com.example.kamechat_backend.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatRestController {
    private final ChatService chatService;

    public ChatRestController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello, world!";
    }

    @GetMapping("/get-all-messages")
    public List<Message> getAllMessages(@RequestParam("chatId") String chatId) {
        return chatService.getAllMessages(chatId);
    }
}
