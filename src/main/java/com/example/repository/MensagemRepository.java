package com.example.repository;

import com.example.entity.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

    List<Mensagem> findByChat_IdAndExcluidaFalseOrderByEnviadaEmAsc(UUID chatId);
}
