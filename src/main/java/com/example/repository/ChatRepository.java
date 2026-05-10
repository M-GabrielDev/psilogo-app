package com.example.repository;

import com.example.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
}
