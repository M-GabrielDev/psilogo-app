package com.example.tabela_especialistas.Controller;

import com.example.tabela_especialistas.especialista.DadosCadastroEspecialista;
import com.example.tabela_especialistas.especialista.Especialista;
import com.example.tabela_especialistas.especialista.EspecialistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("especialista")
public class EspecialistaController {

    @Autowired
    private EspecialistaRepository repository;

    @PostMapping
    public void cadastro(@RequestBody DadosCadastroEspecialista dados){
        repository.save(new Especialista(dados));
    }
}
