package com.example.tabela_usuarios.usuario;

public record DadosCadastroUsuario(
        String nomeCompleto,
        String apelidoAnonimo,
        String email,
        String senha,
        String telefone,
        String fotoPerfil) {

}
