package com.example.controller;
// atualizando o "Controller" para poder jogar no post e ver como se comporta no get.

import com.example.DTO.DadosCadastroEspecialista;
import com.example.entity.Especialista;
import com.example.repository.EspecialistaRepository;
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
    public void cadastro(@RequestBody DadosCadastroEspecialista dados){
        repository.save(new Especialista(dados));
    }

    @GetMapping
    public List<Especialista> listar() {
        return repository.findAll();
    }
}