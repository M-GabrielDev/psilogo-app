package com.example.tabela_especialistas.especialista;

import java.math.BigDecimal;

public record DadosCadastroEspecialista(
        String nomeCompleto,
        String crm,
        String especialidade,
        String biografia,
        Boolean disponivel,
        BigDecimal notaMedia) {
}
