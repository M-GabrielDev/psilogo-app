package com.example.service;

import com.example.entity.ConteudoEducativo;
import com.example.repository.ConteudoEducativoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteudoEducativoService {

    private final ConteudoEducativoRepository repository;

    public ConteudoEducativoService(ConteudoEducativoRepository repository) {
        this.repository = repository;
    }

    public List<ConteudoEducativo> listarConteudos() {
        return repository.findAll();
    }
}
