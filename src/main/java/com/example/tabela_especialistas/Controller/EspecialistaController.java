package com.example.tabela_especialistas.Controller;
// atualizando o "Controller" para poder jogar no post e ver como se comporta no get.
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/especialistas")
public class EspecialistaController {

    private final EspecialistaRepository repository;

    public EspecialistaController(EspecialistaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Especialista> listar() {
        return repository.findAll();
    }
}
// O controle dos especialistas estar completo.
