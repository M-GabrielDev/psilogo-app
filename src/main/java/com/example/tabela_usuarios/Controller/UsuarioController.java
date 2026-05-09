package com.example.tabela_usuarios.Controller;


import com.example.tabela_usuarios.usuario.DadosCadastroUsuario;
import com.example.tabela_usuarios.usuario.Usuario;
import com.example.tabela_usuarios.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("cadastros")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public void cadastro(@RequestBody DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

}
