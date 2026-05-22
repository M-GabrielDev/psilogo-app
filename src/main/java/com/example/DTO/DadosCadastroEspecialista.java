package com.example.DTO;

import com.example.entity.Especialista;

import java.math.BigDecimal;
import java.util.UUID;

public record DadosCadastroEspecialista(UUID usuario_id,
                                        String nomeCompleto,
                                        String nome,
                                        String credenciais,
                                        String crm,
                                        String especialidade,
                                        String biografia,
                                        Boolean disponivel,
                                        BigDecimal notaMedia) { }
