package com.example.entity;

import com.example.DTO.DadosCadastroEspecialista;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "especialistas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "usuario_id")
public class Especialista {


    // atualizei essa parte, pois Generate com UUID já gerado, pode dá erro no código.
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID usuario_id;
    private String nomeCompleto;
    private String crm;
    private String especialidade;

    @Size(max = 2000, message = "Biografia muito longa")
    @Column(columnDefinition = "TEXT")
    private String biografia;
    private Boolean disponivel;

    @DecimalMin(value = "0.0", message = "Nota não pode ser negativa")
    @DecimalMax(value = "5.0", message = "Nota não pode ser maior que 5")
    @Digits(integer = 1, fraction = 2)
    @Column(name = "nota_media", precision = 3, scale = 2)
    private BigDecimal notaMedia = BigDecimal.valueOf(5.0);

    public Especialista(DadosCadastroEspecialista dados){
        this.nomeCompleto = dados.nomeCompleto();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.biografia = dados.biografia();
        this.disponivel = dados.disponivel();
        this.notaMedia = BigDecimal.valueOf(5.0);

    }


}
