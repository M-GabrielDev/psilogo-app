package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "autenticacao_token")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AutenticacaoToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer tipo;

    @Column(nullable = false, length = 255)
    private String token;

    @Column(name = "expira_em", nullable = false)
    private LocalDateTime expiraEm;

    @Column(name = "usado_em")
    private LocalDateTime usadoEm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario usuario;

    public AutenticacaoToken(Usuario usuario, String token, Integer tipo, LocalDateTime expiraEm) {
        this.usuario  = usuario;
        this.token    = token;
        this.tipo     = tipo;
        this.expiraEm = expiraEm;
    }

    public void marcarComoUsado() {
        this.usadoEm = LocalDateTime.now();
    }
}
