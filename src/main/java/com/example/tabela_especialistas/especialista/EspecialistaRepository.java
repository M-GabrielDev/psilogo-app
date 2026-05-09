package com.example.tabela_especialistas.especialista;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EspecialistaRepository extends JpaRepository<Especialista, UUID> {
}
