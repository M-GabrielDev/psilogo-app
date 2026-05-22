package com.example.DTO;

import com.example.entity.Mensagem;
import com.example.enums.TipoMidia;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosListagemMensagem(
        Long id,
        UUID chatId,
        UUID autorId,
        String anonimo,
        String conteudoTexto,
        TipoMidia tipoMidia,
        LocalDateTime enviadaEm,
        LocalDateTime ultimaLeitura,
        Boolean excluida

) {
    public DadosListagemMensagem(Mensagem m) {
        this(
                m.getId(),
                m.getChat().getId(),
                m.getAutor().getId(),
                m.getAutor().getAnonimo(),
                m.getConteudoTexto(),
                m.getTipoMidia(),
                m.getEnviadaEm(),
                m.getUltimaLeitura(),
                m.getExcluida()
        );
    }
}
