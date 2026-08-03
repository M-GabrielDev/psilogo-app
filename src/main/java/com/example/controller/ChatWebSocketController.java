package com.example.controller;

import com.example.DTO.MensagemWebSocket;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    @MessageMapping("/chat/{chatId}")
    @SendTo("/topic/chat/{chatId}")
    public MensagemWebSocket enviarMensagem(
            @DestinationVariable int chatId,
            MensagemWebSocket mensagem) {
        return mensagem;
    }
}
