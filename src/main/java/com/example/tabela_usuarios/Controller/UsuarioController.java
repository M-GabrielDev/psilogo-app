package com.example.tabela_usuarios.Controller;


import com.example.tabela_usuarios.usuario.DadosCadastroUsuario;
import com.example.tabela_usuarios.usuario.Usuario;
import com.example.tabela_usuarios.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("cadastros")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public void cadastro(@RequestBody DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }

}
