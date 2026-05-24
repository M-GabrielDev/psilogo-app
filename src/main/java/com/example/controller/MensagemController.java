package com.example.controller;

import com.example.DTO.DadosCadastroMensagem;
import com.example.DTO.DadosListagemMensagem;
import com.example.service.MensagemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagens")
@RequiredArgsConstructor
public class MensagemController {

    private final MensagemService service;

    @PostMapping
    public ResponseEntity<DadosListagemMensagem> enviar(
            @RequestBody @Valid DadosCadastroMensagem dados) {
        return ResponseEntity.ok(service.enviar(dados));
    }

    @GetMapping
    public Page<DadosListagemMensagem> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
