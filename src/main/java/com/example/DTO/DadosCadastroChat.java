package com.example.DTO;

import com.example.enums.PrioridadeChat;
import com.example.enums.TipoChat;

public record DadosCadastroChat(
    TipoChat tipo,
    Boolean isAnonymous,
    PrioridadeChat prioridade
    ){

}
