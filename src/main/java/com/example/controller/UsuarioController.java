package com.example.controller;


import com.example.DTO.DadosAtualizacaoUsuario;
import com.example.DTO.DadosCadastroUsuario;
import com.example.DTO.DadosListagemUsuario;
import com.example.entity.Usuario;
import com.example.exceptions.EmailJaCadastradoException;
import com.example.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cadastros")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository repository;

    // POST → cadastra usuário
    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemUsuario> cadastrar(
            @RequestBody @Valid DadosCadastroUsuario dados) {

        if (repository.emailExistente(dados.email())) {
            throw new EmailJaCadastradoException();
        }

        Usuario usuario = new Usuario(dados);
        repository.save(usuario);

        return ResponseEntity.ok(new DadosListagemUsuario(usuario));
    }


    @GetMapping
    public List<DadosListagemUsuario> listar() {
        return repository.findAll()
                .stream()
                .map(DadosListagemUsuario::new)
                .toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemUsuario> buscarPorId(
            @PathVariable UUID id) {
        return repository.findById(id)
                .map(DadosListagemUsuario::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosListagemUsuario> atualizar(
            @PathVariable UUID id,
            @RequestBody @Valid DadosAtualizacaoUsuario dados) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.atualizar(dados);
        repository.save(usuario);

        return ResponseEntity.ok(new DadosListagemUsuario(usuario));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
