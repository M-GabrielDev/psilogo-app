package com.example.repository;

import com.example.entity.ConteudoEducativo;
import com.example.enums.TipoConteudo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConteudoEducativoRepository extends JpaRepository<ConteudoEducativo, Integer> {
    List<ConteudoEducativo> findByPublicadoTrue();
    List<ConteudoEducativo> findByTipo(TipoConteudo tipo);
}
