package com.example.controller;

import com.example.DTO.DadosCadastroConteudoEducativo;
import com.example.DTO.DadosListagemConteudoEducativo;
import com.example.entity.ConteudoEducativo;
import com.example.enums.TipoConteudo;
import com.example.repository.ConteudoEducativoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("conteudos")
@RequiredArgsConstructor
public class ConteudoEducativoController {
    private final ConteudoEducativoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroConteudoEducativo dados) {
        repository.save(new ConteudoEducativo(dados));
    }

    @GetMapping
    public List<DadosListagemConteudoEducativo> listar() {
        return repository.findByPublicadoTrue()
                .stream()
                .map(DadosListagemConteudoEducativo::new)
                .toList();
    }

    @GetMapping("/tipo/{tipo}")
    public List<DadosListagemConteudoEducativo> listarPorTipo(
            @PathVariable String tipo) {
        return repository.findByTipo(TipoConteudo.valueOf(tipo))
                .stream()
                .map(DadosListagemConteudoEducativo::new)
                .toList();
    }
}
