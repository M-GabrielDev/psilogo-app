package com.example.controller;

import com.example.DTO.DadosCadastroParticipanteChat;
import com.example.DTO.DadosListagemParticipanteChat;
import com.example.entity.Chat;
import com.example.entity.ParticipanteChat;
import com.example.entity.ParticipanteChatId;
import com.example.entity.Usuario;
import com.example.repository.ChatRepository;
import com.example.repository.ParticipanteChatRepository;
import com.example.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("participantes")
@RequiredArgsConstructor
public class ParticipanteChatController {
    private final ParticipanteChatRepository participanteRepository;
    private final ChatRepository chatRepository;
    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public void adicionar(@RequestBody DadosCadastroParticipanteChat dados) {
        Chat chat = chatRepository.findById(dados.chatId())
                .orElseThrow(() -> new RuntimeException("Chat não encontrado"));

        Usuario usuario = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        ParticipanteChatId id = new ParticipanteChatId(dados.chatId(), dados.usuarioId());
        ParticipanteChat participante = new ParticipanteChat(id, chat, usuario, null, null);

        participanteRepository.save(participante);
    }

    @GetMapping("/{chatId}")
    public List<DadosListagemParticipanteChat> listarPorChat(
            @PathVariable UUID chatId) {
        return participanteRepository.findById_ChatId(chatId)
                .stream()
                .map(DadosListagemParticipanteChat::new)
                .toList();
    }
}
