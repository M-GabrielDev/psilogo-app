package com.example.entity;

import com.example.DTO.DadosCadastroChat;
import com.example.enums.PrioridadeChat;
import com.example.enums.StatusChat;
import com.example.enums.TipoChat;
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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('direto','grupo','suporte_emergencial')")
    private TipoChat tipo;

    @Column(name = "is_anonymous")
    private Boolean isAnonymous;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('aberto','em_atendimento','encerrado')")
    private StatusChat status;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('baixa','media','alta','urgente')")
    private PrioridadeChat prioridade;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "encerrado_em")
    private LocalDateTime encerradoEm;

    @PrePersist
    protected void onCreate() {
        if (id == null) id = UUID.randomUUID();
        if (criadoEm == null) criadoEm = LocalDateTime.now();
        if (isAnonymous == null) isAnonymous = true;
        if (status == null) status = StatusChat.aberto;
        if (tipo == null) tipo = TipoChat.direto;
        if (prioridade == null) prioridade = PrioridadeChat.media;
    }

    public Chat(DadosCadastroChat dados) {
        this.tipo       = dados.tipo() != null ? dados.tipo() : TipoChat.direto;
        this.isAnonymous = dados.isAnonymous() != null ? dados.isAnonymous() : true;
        this.prioridade = dados.prioridade() != null ? dados.prioridade() : PrioridadeChat.media;
        this.status     = StatusChat.aberto;
    }
}
