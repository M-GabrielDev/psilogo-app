package com.example.psilogo_app.Controller;


import com.example.psilogo_app.usuario.DadosCadastroUsuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cadastros")
public class UsuarioController {

    @PostMapping
    public void cadastro(@RequestBody DadosCadastroUsuario dados) {
        System.out.println(dados);
    }

}
