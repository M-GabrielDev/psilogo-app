package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;

import java.io.Serializable;
import java.util.UUID;

public class ParticipanteChatId implements Serializable {

    @Column(name = "chat_id", columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDConverter.class)
    private UUID chatId;

    @Column(name = "usuario_id", columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDConverter.class)
    private UUID usuarioId;
}
