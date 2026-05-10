package com.example.repository;

import com.example.entity.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EspecialistaRepository extends JpaRepository<Especialista, UUID> {
}
