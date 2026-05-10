package com.example.DTO;

import com.example.enums.TipoConteudo;

public record DadosCadastroConteudoEducativo(
        String titulo,
        String descricao,
        TipoConteudo tipo,
        String urlArquivo,
        Integer duracaoMinutos,
        Boolean publicado
) {
}
