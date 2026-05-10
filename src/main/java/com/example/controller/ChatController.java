package com.example.controller;

import com.example.DTO.DadosCadastroChat;
import com.example.DTO.DadosListagemChat;
import com.example.entity.Chat;
import com.example.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroChat dados) {
        repository.save(new Chat(dados));
    }

    @GetMapping
    public List<DadosListagemChat> listar() {
        return repository.findAll().stream().map(DadosListagemChat::new).toList();
    }
}
