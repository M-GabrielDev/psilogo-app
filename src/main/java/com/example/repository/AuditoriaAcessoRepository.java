package com.example.repository;

import com.example.entity.AuditoriaAcesso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AuditoriaAcessoRepository extends JpaRepository<AuditoriaAcesso, Long> {

    List<AuditoriaAcesso> findByEspecialista_Id(UUID especialistaId);
    List<AuditoriaAcesso> findByPaciente_Id(UUID pacienteId);

}
