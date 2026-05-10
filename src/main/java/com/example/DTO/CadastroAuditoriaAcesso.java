package com.example.DTO;

import java.util.UUID;

public record CadastroAuditoriaAcesso(
        UUID especialistaId,
        UUID pacienteId,
        String acao
) {
}
