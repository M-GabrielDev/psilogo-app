package com.example.DTO;

public record MensagemWebSocket(
        Integer remetenteId,
        Integer chatId,
        String conteudoTexto
) {}
