package com.example.repository;

import java.util.UUID;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    List<Mensagem> findByChat_IdAndExcluidaEmIsNullOrderByEnviadaEmAsc(UUID chatId);
}
