package com.example.DTO;

import java.util.UUID;

public record DadosCadastroMensagem(
        UUID chatId,
        UUID autorId,
        String conteudoTexto,
        String urlMidia,
        TipoMidia tipoMidia
) {
}
