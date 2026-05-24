package com.example.DTO;

import com.example.entity.Chat;
import com.example.enums.PrioridadeChat;
import com.example.enums.StatusChat;
import java.time.LocalTime;

public record DadosListagemChat(
        Integer id,
        Integer usuarioId,
        Integer especialistaId,
        StatusChat status,
        PrioridadeChat prioridade,
        LocalTime entrouEm,
        LocalTime encerradoEm
) {
    public DadosListagemChat(Chat chat) {
        this(
                chat.getId(),
                chat.getUsuario().getId(),
                chat.getEspecialista().getId(),
                chat.getStatus(),
                chat.getPrioridade(),
                chat.getEntrouEm(),
                chat.getEncerradoEm()
        );
    }
}
