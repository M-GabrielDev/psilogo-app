package com.example.DTO;

import com.example.entity.Chat;
import com.example.enums.PrioridadeChat;
import com.example.enums.StatusChat;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosListagemChat(
        UUID id,
        UUID usuarioId,
        UUID especialistaId,
        StatusChat status,
        PrioridadeChat prioridade,
        LocalDateTime entrouEm,
        LocalDateTime encerradoEm
) {
    public DadosListagemChat(Chat chat) {
        this(
                chat.getId(),
                chat.getUsuario().getId(),
                chat.getEspecialista().getUsuario_id(),
                chat.getStatus(),
                chat.getPrioridade(),
                chat.getEntrouEm(),
                chat.getEncerradoEm()
        );
    }
}
