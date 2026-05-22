package com.example.entity;

import com.example.DTO.DadosCadastroChat;
import com.example.converter.UUIDConverter;
import com.example.enums.PrioridadeChat;
import com.example.enums.StatusChat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "chats")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Chat {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDConverter.class)
    private UUID id;

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
    private LocalDateTime entrouEm;

    @Column(name = "encerrado_em")
    private LocalDateTime encerradoEm;

    @PrePersist
    protected void onCreate() {
        if (id == null) id = UUID.randomUUID();
        if (entrouEm == null) entrouEm = LocalDateTime.now();
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
        this.status     = StatusChat.encerrado;
        this.encerradoEm = LocalDateTime.now();
    }
}


