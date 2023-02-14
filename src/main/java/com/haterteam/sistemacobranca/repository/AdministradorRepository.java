package com.haterteam.sistemacobranca.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haterteam.sistemacobranca.model.Administrador;

import jakarta.validation.Valid;

public interface AdministradorRepository extends JpaRepository<Administrador, UUID>{

    Boolean existsByLogin(@Valid String login);

    Optional<List<Administrador>> findByLoginStartsWith(String login);

    Optional<Administrador> findByLogin(@Valid String login);
    
}

