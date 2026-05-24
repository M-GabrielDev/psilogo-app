package com.example.service;

import com.example.entity.Chat;
import com.example.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final ChatRepository repository;

    public ChatService(ChatRepository repository) {
        this.repository = repository;
    }

    public List<Chat> listarChats() {
        return repository.findAll();
    }
}
