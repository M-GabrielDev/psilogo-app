package com.example.entity;

import com.example.DTO.DadosCadastroMensagem;
import com.example.enums.TipoMidia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensagens")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario autor;

    @Column(name = "conteudo_texto", columnDefinition = "TEXT")
    private String conteudoTexto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_midia",
            columnDefinition = "ENUM('texto','audio','imagem','video')")
    private TipoMidia tipoMidia;

    @Column(name = "enviada_em")
    private LocalDateTime enviadaEm;

    @Column(name = "ultima_leitura")
    private LocalDateTime ultimaLeitura;   // ← novo

    @Column(name = "excluida")
    private Boolean excluida = false;      // ← novo

    @PrePersist
    protected void onCreate() {
        if (enviadaEm == null) enviadaEm = LocalDateTime.now();
        if (tipoMidia == null) tipoMidia = TipoMidia.texto;
        if (excluida == null) excluida = false;
    }

    public void excluir() {
        this.excluida = true;
    }

    public Mensagem(DadosCadastroMensagem dados, Chat chat, Usuario autor) {
        this.chat          = chat;
        this.autor         = autor;
        this.conteudoTexto = dados.conteudoTexto();
        this.tipoMidia     = dados.tipoMidia() != null ? dados.tipoMidia() : TipoMidia.texto;
    }
}
