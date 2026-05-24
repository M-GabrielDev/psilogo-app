package com.example.service;

import com.example.entity.AuditoriaAcesso;
import com.example.repository.AuditoriaAcessoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaAcessoService {

    private final AuditoriaAcessoRepository repository;

    public AuditoriaAcessoService(AuditoriaAcessoRepository repository) {
        this.repository = repository;
    }

    public List<AuditoriaAcesso> listarAuditorias() {
        return repository.findAll();
    }
}
