package com.example.controller;

import com.example.DTO.DadosCadastroChat;
import com.example.DTO.DadosListagemChat;
import com.example.entity.Chat;
import com.example.entity.Especialista;
import com.example.entity.Usuario;
import com.example.repository.ChatRepository;
import com.example.repository.EspecialistaRepository;
import com.example.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatRepository chatRepository;
    private final UsuarioRepository usuarioRepository;
    private final EspecialistaRepository especialistaRepository;

    @PostMapping
    public ResponseEntity<DadosListagemChat> cadastrar(
            @RequestBody DadosCadastroChat dados) {

        Usuario usuario = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Especialista especialista = especialistaRepository.findById(dados.especialistaId())
                .orElseThrow(() -> new RuntimeException("Especialista não encontrado"));

        Chat chat = new Chat(dados, usuario, especialista);
        chatRepository.save(chat);

        return ResponseEntity.ok(new DadosListagemChat(chat));
    }


    @GetMapping
    public List<DadosListagemChat> listar() {
        return chatRepository.findAll()
                .stream()
                .map(DadosListagemChat::new)
                .toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemChat> buscarPorId(
            @PathVariable UUID id) {
        return chatRepository.findById(id)
                .map(DadosListagemChat::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}/encerrar")
    public ResponseEntity<DadosListagemChat> encerrar(
            @PathVariable UUID id) {
        Chat chat = chatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chat não encontrado"));

        chat.encerrar();
        chatRepository.save(chat);

        return ResponseEntity.ok(new DadosListagemChat(chat));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        chatRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
