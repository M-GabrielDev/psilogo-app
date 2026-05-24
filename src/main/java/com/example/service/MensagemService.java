package com.example.service;

import com.example.entity.Mensagem;
import com.example.repository.MensagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemService {

    private final MensagemRepository repository;

    public MensagemService(MensagemRepository repository) {
        this.repository = repository;
    }

    public List<Mensagem> listarMensagens() {
        return repository.findAll();
    }
}
