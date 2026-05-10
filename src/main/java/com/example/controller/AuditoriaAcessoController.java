package com.example.controller;

import com.example.DTO.DadosListagemAuditoriaAcesso;
import com.example.entity.AuditoriaAcesso;
import com.example.entity.Usuario;
import com.example.repository.AuditoriaAcessoRepository;
import com.example.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("auditoria")
@RequiredArgsConstructor
public class AuditoriaAcessoController {

    private final AuditoriaAcessoRepository auditoriaRepository;
    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrar(@RequestBody DadosCadastroAuditoriaAcesso dados) {
        Usuario especialista = usuarioRepository.findById(dados.especialistaId())
                .orElseThrow(() -> new RuntimeException("Especialista não encontrado"));

        Usuario paciente = usuarioRepository.findById(dados.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        auditoriaRepository.save(
                new AuditoriaAcesso(dados, especialista, paciente));
    }

    @GetMapping("/especialista/{especialistaId}")
    public List<DadosListagemAuditoriaAcesso> listarPorEspecialista(
            @PathVariable UUID especialistaId) {
        return auditoriaRepository.findByEspecialista_Id(especialistaId)
                .stream()
                .map(DadosListagemAuditoriaAcesso::new)
                .toList();
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<DadosListagemAuditoriaAcesso> listarPorPaciente(
            @PathVariable UUID pacienteId) {
        return auditoriaRepository.findByPaciente_Id(pacienteId)
                .stream()
                .map(DadosListagemAuditoriaAcesso::new)
                .toList();
    }
}
