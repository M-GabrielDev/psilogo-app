package com.example.DTO;

import com.example.enums.PrioridadeChat;
import java.util.UUID;

public record DadosCadastroChat(
        UUID usuarioId,
        UUID especialistaId,
        PrioridadeChat prioridade
    ){

}
