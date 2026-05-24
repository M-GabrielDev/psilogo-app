package com.example.controller;

import com.example.DTO.DadosCadastroChat;
import com.example.DTO.DadosListagemChat;
import com.example.service.ChatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService service;

    @PostMapping
    public ResponseEntity<DadosListagemChat> cadastrar(
            @RequestBody @Valid DadosCadastroChat dados) {
        return ResponseEntity.ok(service.cadastrar(dados));
    }

    @GetMapping
    public Page<DadosListagemChat> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemChat> buscarPorId(
            @PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}/encerrar")
    public ResponseEntity<DadosListagemChat> encerrar(
            @PathVariable Integer id) {
        return ResponseEntity.ok(service.encerrar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
