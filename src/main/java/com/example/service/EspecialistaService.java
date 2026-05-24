package com.example.service;

import com.example.entity.Especialista;
import com.example.repository.EspecialistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialistaService {

    private final EspecialistaRepository repository;

    public EspecialistaService(EspecialistaRepository repository) {
        this.repository = repository;
    }

    public List<Especialista> listarEspecialistas() {
        return repository.findAll();
    }
}

