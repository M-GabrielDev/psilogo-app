package com.example.repository;

import com.example.entity.ParticipanteChat;
import com.example.entity.ParticipanteChatId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ParticipanteChatRepository extends JpaRepository<ParticipanteChat, ParticipanteChatId> {

        List<ParticipanteChat> findById_ChatId(UUID chatId);
        List<ParticipanteChat> findById_UsuarioId(UUID usuarioId);
    }

}
