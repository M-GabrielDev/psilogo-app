package com.example.controller;
// atualizando o "Controller" para poder jogar no post e ver como se comporta no get.

import com.example.DTO.DadosAtualizacaoEspecialista;
import com.example.DTO.DadosCadastroEspecialista;
import com.example.entity.Especialista;
import com.example.repository.EspecialistaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/especialistas")
public class EspecialistaController {

    private final EspecialistaRepository repository;

    public EspecialistaController(EspecialistaRepository repository) {
        this.repository = repository;
    }
    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroEspecialista dados){
        repository.save(new Especialista(dados));
    }

    @GetMapping
    public List<Especialista> listar(@PageableDefault(size = 10, sort = {"nomeCompleto"})) {
        return repository.findAll().stream().map(DadosCadastroEspecialista::new).toList();
    }


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoEspecialista dados) {

    }
}