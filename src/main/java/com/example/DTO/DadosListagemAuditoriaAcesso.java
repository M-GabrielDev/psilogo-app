package com.example.DTO;

import com.example.entity.AuditoriaAcesso;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosListagemAuditoriaAcesso(

        Long id,
        UUID especialistaId,
        String nomeEspecialista,
        UUID pacienteId,
        String nomePaciente,
        String acao,
        LocalDateTime dataHora
) {
    public DadosListagemAuditoriaAcesso(AuditoriaAcesso a) {
        this(
                a.getId(),
                a.getEspecialista().getId(),
                a.getEspecialista().getNomeCompleto(),
                a.getPaciente().getId(),
                a.getPaciente().getNomeCompleto(),
                a.getAcao(),
                a.getDataHora()
        );
    }
}
