package com.example.psilogo_app.usuario;

import com.example.psilogo_app.tipoConta.StatusConta;
import com.example.psilogo_app.tipoConta.TipoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class Usuario {
    private UUID id;
    private String nomeCompleto;
    private String apelidoAnonimo;
    private String email;
    private String senha;
    private String telefone;
    private String fotoPerfil;
    private TipoUsuario tipo;
    private StatusConta status;
    private LocalDateTime emailVerificadoEm;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

}
