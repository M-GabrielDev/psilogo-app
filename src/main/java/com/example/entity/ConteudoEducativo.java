package com.example.entity;

import com.example.enums.TipoConteudo;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class ConteudoEducativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,
            columnDefinition = "ENUM('tecnica','exercicio','leitura','audio_guia')")
    private TipoConteudo tipo;

    @Column(name = "url_arquivo", nullable = false)
    private String urlArquivo;

    @Column(name = "duracao_minutos")
    private Integer duracaoMinutos;

    private Boolean publicado;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @PrePersist
    protected void onCreate() {
        if (criadoEm == null) criadoEm = LocalDateTime.now();
        if (publicado == null) publicado = true;
    }

    public ConteudoEducativo(DadosCadastroConteudoEducativo dados) {
        this.titulo         = dados.titulo();
        this.descricao      = dados.descricao();
        this.tipo           = dados.tipo();
        this.urlArquivo     = dados.urlArquivo();
        this.duracaoMinutos = dados.duracaoMinutos();
        this.publicado      = dados.publicado() != null ? dados.publicado() : true;
    }
}
