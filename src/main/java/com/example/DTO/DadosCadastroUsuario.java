package com.example.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosCadastroUsuario(
        @NotBlank String nomeCompleto,
        String anonimo,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 8) String senha,
        @Pattern(regexp = "\\d{10,11}") String telefone,
        String fotoPerfil,
        String imagemAvatar
) {}
