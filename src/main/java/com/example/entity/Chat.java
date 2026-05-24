package com.example.entity;

import com.example.DTO.DadosCadastroChat;
import com.example.enums.PrioridadeChat;
import com.example.enums.StatusChat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Entity
@Table(name = "Chat")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialista_id", nullable = false)
    private Especialista especialista;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('aberto','em_atendimento','encerrado')")
    private StatusChat status;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('baixa','media','alta','urgente')")
    private PrioridadeChat prioridade;

    @Column(name = "entrou_em")
    private LocalTime entrouEm;

    @Column(name = "encerrado_em")
    private LocalTime encerradoEm;

    @PrePersist
    protected void onCreate() {
        if (entrouEm == null) entrouEm = LocalTime.now();
        if (status == null) status = StatusChat.aberto;
        if (prioridade == null) prioridade = PrioridadeChat.media;
    }

    public Chat(DadosCadastroChat dados, Usuario usuario, Especialista especialista) {
        this.usuario      = usuario;
        this.especialista = especialista;
        this.prioridade   = dados.prioridade() != null ? dados.prioridade() : PrioridadeChat.media;
        this.status       = StatusChat.aberto;
    }

    public void encerrar() {
        this.status      = StatusChat.encerrado;
        this.encerradoEm = LocalTime.now();
    }
}


