package com.example.DTO;

import com.example.enums.TipoMidia;
import java.util.UUID;

public record DadosCadastroMensagem(

        UUID chatId,
        UUID autorId,
        String conteudoTexto,
        TipoMidia tipoMidia

) {}
