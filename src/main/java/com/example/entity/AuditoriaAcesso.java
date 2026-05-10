package com.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class AuditoriaAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialista_id", nullable = false)
    private Usuario especialista;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Usuario paciente;

    @Column(nullable = false, length = 100)
    private String acao;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @PrePersist
    protected void onCreate() {
        if (dataHora == null) dataHora = LocalDateTime.now();
    }

    public AuditoriaAcesso(DadosCadastroAuditoriaAcesso dados,
                           Usuario especialista,
                           Usuario paciente) {
        this.especialista = especialista;
        this.paciente     = paciente;
        this.acao         = dados.acao();
    }
}
