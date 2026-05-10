package com.example.DTO;

import com.example.entity.Especialista;

import java.math.BigDecimal;
import java.util.UUID;

public record DadosCadastroEspecialista(UUID usuario_id, String nomeCompleto, String crm, String especialidade, String biografia, Boolean disponivel, BigDecimal notaMedia) {

    public DadosCadastroEspecialista(Especialista especialista) {
        this(especialista.getUsuario_id(),especialista.nomeCompleto(), especialista.getCrm(),especialista.getBiografia(), especialista.getEspecialidade(), especialista.getDisponivel(),especialista.getNotaMedia())
    }

}
