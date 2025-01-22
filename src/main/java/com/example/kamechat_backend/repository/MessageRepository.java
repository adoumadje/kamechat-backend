package com.example.kamechat_backend.repository;

import com.example.kamechat_backend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByChatIdOrderByTimestampAsc(String chatId);
}
