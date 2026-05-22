package com.example.controller;

import com.example.DTO.DadosCadastroMensagem;
import com.example.DTO.DadosListagemMensagem;
import com.example.entity.Chat;
import com.example.entity.Mensagem;
import com.example.entity.Usuario;
import com.example.repository.ChatRepository;
import com.example.repository.MensagemRepository;
import com.example.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("mensagens")
@RequiredArgsConstructor
public class MensagemController {

    private final MensagemRepository mensagemRepository;
    private final ChatRepository chatRepository;
    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<DadosListagemMensagem> enviar(
            @RequestBody DadosCadastroMensagem dados) {

        Chat chat = chatRepository.findById(dados.chatId())
                .orElseThrow(() -> new RuntimeException("Chat não encontrado"));

        Usuario autor = usuarioRepository.findById(dados.autorId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Mensagem mensagem = new Mensagem(dados, chat, autor);
        mensagemRepository.save(mensagem);

        return ResponseEntity.ok(new DadosListagemMensagem(mensagem));
    }


    @GetMapping("/{chatId}")
    public List<DadosListagemMensagem> listarPorChat(
            @PathVariable UUID chatId) {
        return mensagemRepository
                .findByChat_IdAndExcluidaFalseOrderByEnviadaEmAsc(chatId)
                .stream()
                .map(DadosListagemMensagem::new)
                .toList();
    }

    // DELETE → exclui mensagem logicamente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Mensagem mensagem = mensagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensagem não encontrada"));

        mensagem.excluir();
        mensagemRepository.save(mensagem);

        return ResponseEntity.noContent().build();
    }
}
