package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "participantes_chat")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipanteChat {
    @EmbeddedId
    private ParticipanteChatId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("chatId")
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "entrou_em")
    private LocalDateTime entrouEm;

    @Column(name = "ultima_leitura_em")
    private LocalDateTime ultimaLeituraEm;

    @PrePersist
    protected void onCreate() {
        if (entrouEm == null) entrouEm = LocalDateTime.now();
    }
}
