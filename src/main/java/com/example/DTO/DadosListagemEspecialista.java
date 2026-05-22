package com.example.DTO;

import com.example.entity.Especialista;
import java.math.BigDecimal;
import java.util.UUID;

public record DadosListagemEspecialista(

        UUID usuarioId,
        String nome,
        String nomeCompleto,
        String crm,
        String especialidade,
        String biografia,
        String credenciais,
        Boolean disponivel,
        BigDecimal notaMedia

) {
    public DadosListagemEspecialista(Especialista e) {
        this(
                e.getUsuario_id(),
                e.getNome(),
                e.getNomeCompleto(),
                e.getCrm(),
                e.getEspecialidade(),
                e.getBiografia(),
                e.getCredenciais(),
                e.getDisponivel(),
                e.getNotaMedia()
        );
    }
}
