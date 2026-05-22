
package com.example.DTO;

import java.util.UUID;

public record DadosAtualizacaoEspecialista(String nome,
                                           String especialidade,
                                           String biografia,
                                           String credenciais,
                                           Boolean disponivel) {
}
