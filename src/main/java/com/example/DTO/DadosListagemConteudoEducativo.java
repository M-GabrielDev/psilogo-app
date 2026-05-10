package com.example.DTO;

import com.example.entity.ConteudoEducativo;
import com.example.enums.TipoConteudo;

import java.time.LocalDateTime;

public record DadosListagemConteudoEducativo(
        Integer id,
        String titulo,
        String descricao,
        TipoConteudo tipo,
        String urlArquivo,
        Integer duracaoMinutos,
        Boolean publicado,
        LocalDateTime criadoEm
) {
    public DadosListagemConteudoEducativo(ConteudoEducativo c) {
        this(
                c.getId(),
                c.getTitulo(),
                c.getDescricao(),
                c.getTipo(),
                c.getUrlArquivo(),
                c.getDuracaoMinutos(),
                c.getPublicado(),
                c.getCriadoEm()
        );
    }
}
