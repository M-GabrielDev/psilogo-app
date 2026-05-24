package com.example.service;

import com.example.DTO.DadosCadastroMensagem;
import com.example.DTO.DadosListagemMensagem;
import com.example.entity.Mensagem;
import com.example.entity.Usuario;
import com.example.exceptions.RecursoNaoEncontradoException;
import com.example.repository.MensagemRepository;
import com.example.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MensagemService {

    private final MensagemRepository mensagemRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public DadosListagemMensagem enviar(DadosCadastroMensagem dados) {
        Usuario autor = usuarioRepository.findById(dados.autorId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário"));
        Mensagem mensagem = new Mensagem(dados, autor);
        return new DadosListagemMensagem(mensagemRepository.save(mensagem));
    }

    public Page<DadosListagemMensagem> listar(Pageable pageable) {
        return mensagemRepository.findAll(pageable)
                .map(DadosListagemMensagem::new);
    }

    @Transactional
    public void excluir(Integer id) {
        Mensagem mensagem = mensagemRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Mensagem"));
        mensagem.excluir();
        mensagemRepository.save(mensagem);
    }
}
