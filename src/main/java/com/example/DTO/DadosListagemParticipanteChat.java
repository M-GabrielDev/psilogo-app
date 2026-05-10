package com.example.DTO;

import com.example.entity.ParticipanteChat;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosListagemParticipanteChat(
        UUID chatId,
        UUID usuarioId,
        String nomeCompleto,
        String apelidoAnonimo,
        LocalDateTime entrouEm,
        LocalDateTime ultimaLeituraEm
) {
    public DadosListagemParticipanteChat(ParticipanteChat participante) {
        this(
                participante.getId().getChatId(),
                participante.getId().getUsuarioId(),
                participante.getUsuario().getNomeCompleto(),
                participante.getUsuario().getApelidoAnonimo(),
                participante.getEntrouEm(),
                participante.getUltimaLeituraEm()
        );
}
