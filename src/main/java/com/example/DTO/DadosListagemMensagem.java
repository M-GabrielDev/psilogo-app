package com.example.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosListagemMensagem(
        Long id,
        UUID chatId,
        UUID autorId,
        String apelidoAutor,
        String conteudoTexto,
        String urlMidia,
        TipoMidia tipoMidia,
        LocalDateTime enviadaEm
) {
    public DadosListagemMensagem(Mensagem m) {
        this(
                m.getId(),
                m.getChat().getId(),
                m.getAutor().getId(),
                m.getAutor().getApelidoAnonimo(),
                m.getConteudoTexto(),
                m.getUrlMidia(),
                m.getTipoMidia(),
                m.getEnviadaEm()
        );
    }
}
