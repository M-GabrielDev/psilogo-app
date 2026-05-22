package com.example.entity;

import com.example.DTO.DadosAtualizacaoUsuario;
import com.example.DTO.DadosCadastroUsuario;
import com.example.enums.StatusConta;
import com.example.enums.TipoUsuario;
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
    private String anonimo;
    private String email;

    @Column(name = "senha_hash", nullable = false, length = 255)
    private String senha;
    private String telefone;
    private String fotoPerfil;
    private String imagemAvatar;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'pendente'")
    private StatusConta status;
    private LocalDateTime emailVerificadoEm;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    @PrePersist
    protected void onCreate() {
        if (id == null) id = UUID.randomUUID();
    }

    public Usuario(DadosCadastroUsuario dados) {
        this.nomeCompleto = dados.nomeCompleto();
        this.anonimo      = dados.anonimo();
        this.email        = dados.email();
        this.senha        = dados.senha();
        this.telefone     = dados.telefone();
        this.fotoPerfil   = dados.fotoPerfil();
        this.imagemAvatar = dados.imagemAvatar();
        this.tipo         = TipoUsuario.paciente;
        this.status       = StatusConta.pendente;
        this.criadoEm     = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
    }
    public void atualizar(DadosAtualizacaoUsuario dados) {
        if (dados.nomeCompleto() != null)  this.nomeCompleto  = dados.nomeCompleto();
        if (dados.anonimo() != null)       this.anonimo       = dados.anonimo();
        if (dados.telefone() != null)      this.telefone      = dados.telefone();
        if (dados.fotoPerfil() != null)    this.fotoPerfil    = dados.fotoPerfil();
        if (dados.imagemAvatar() != null)  this.imagemAvatar  = dados.imagemAvatar();
    }
}
