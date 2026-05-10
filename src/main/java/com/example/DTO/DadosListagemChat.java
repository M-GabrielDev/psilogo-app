package com.example.DTO;

import com.example.entity.Chat;
import com.example.enums.PrioridadeChat;
import com.example.enums.StatusChat;
import com.example.enums.TipoChat;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosListagemChat(
    UUID id,
    TipoChat tipo,
    Boolean isAnonymous,
    StatusChat status,
    PrioridadeChat prioridade,
    LocalDateTime criadoEm,
    LocalDateTime encerradoEm
) {
    public DadosListagemChat(Chat chat) {
            this(
                    chat.getId(),
                    chat.getTipo(),
                    chat.getIsAnonymous(),
                    chat.getStatus(),
                    chat.getPrioridade(),
                    chat.getCriadoEm(),
                    chat.getEncerradoEm()
            );
        }
}
