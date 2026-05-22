package com.example.controller;
// atualizando o "Controller" para poder jogar no post e ver como se comporta no get.

import com.example.DTO.DadosAtualizacaoEspecialista;
import com.example.DTO.DadosCadastroEspecialista;
import com.example.DTO.DadosListagemEspecialista;
import com.example.entity.Especialista;
import com.example.repository.EspecialistaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/especialistas")
@RequiredArgsConstructor
public class EspecialistaController {

    private final EspecialistaRepository repository;

    // POST → cadastra especialista
    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemEspecialista> cadastrar(
            @RequestBody @Valid DadosCadastroEspecialista dados) {
        Especialista especialista = new Especialista(dados);
        repository.save(especialista);
        return ResponseEntity.ok(new DadosListagemEspecialista(especialista));
    }

    // GET → lista todos os especialistas
    @GetMapping
    public List<DadosListagemEspecialista> listar() {
        return repository.findAll()
                .stream()
                .map(DadosListagemEspecialista::new)
                .toList();
    }

    // GET → busca especialista por id
    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemEspecialista> buscarPorId(
            @PathVariable UUID id) {
        return repository.findById(id)
                .map(DadosListagemEspecialista::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT → atualiza especialista
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosListagemEspecialista> atualizar(
            @PathVariable UUID id,
            @RequestBody @Valid DadosAtualizacaoEspecialista dados) {
        Especialista especialista = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialista não encontrado"));

        especialista.atualizar(dados);
        repository.save(especialista);

        return ResponseEntity.ok(new DadosListagemEspecialista(especialista));
    }

    // DELETE → deleta especialista
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}