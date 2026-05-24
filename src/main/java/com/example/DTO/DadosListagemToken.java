package com.example.DTO;

import com.example.entity.AutenticacaoToken;
import java.time.LocalDateTime;

public record DadosListagemToken(
        Integer id,
        Integer tipo,
        String token,
        LocalDateTime expiraEm,
        LocalDateTime usadoEm,
        Integer usuarioId
) {
    public DadosListagemToken(AutenticacaoToken t) {
        this(
                t.getId(),
                t.getTipo(),
                t.getToken(),
                t.getExpiraEm(),
                t.getUsadoEm(),
                t.getUsuario().getId()
        );
    }
}
