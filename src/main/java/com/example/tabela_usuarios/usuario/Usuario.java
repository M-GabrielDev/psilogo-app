package com.example.tabela_usuarios.usuario;

import com.example.tabela_usuarios.tipoConta.StatusConta;
import com.example.tabela_usuarios.tipoConta.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue
    private UUID id;
    private String nomeCompleto;
    private String apelidoAnonimo;
    private String email;

    @Column(name = "senha_hash", nullable = false, length = 255)
    private String senha;
    private String telefone;
    private String fotoPerfil;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'pendente'")
    private StatusConta status;
    private LocalDateTime emailVerificadoEm;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Usuario(DadosCadastroUsuario dados) {
        this.nomeCompleto = dados.nomeCompleto();
        this.apelidoAnonimo = dados.apelidoAnonimo();
        this.email = dados.email();
        this.senha = dados.senha();
        this.telefone = dados.telefone();
        this.fotoPerfil = dados.fotoPerfil();
        this.tipo = TipoUsuario.PACIENTE;
        this.status = StatusConta.PENDENTE;
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();



    }
}
