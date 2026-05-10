package com.example.controller;


import com.example.DTO.DadosCadastroUsuario;
import com.example.entity.Usuario;
import com.example.exceptions.EmailJaCadastradoException;
import com.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("cadastros")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public void cadastro(@RequestBody DadosCadastroUsuario dados) {
        if (repository.emailExistente(dados.email())) {
            throw new EmailJaCadastradoException();
        }
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

}
