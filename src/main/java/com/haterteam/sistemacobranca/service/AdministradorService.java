package com.haterteam.sistemacobranca.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.haterteam.sistemacobranca.model.Administrador;
import com.haterteam.sistemacobranca.repository.AdministradorRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class AdministradorService {

    final AdministradorRepository administradorRepository;

    public AdministradorService(AdministradorRepository administradorRepository){
        this.administradorRepository = administradorRepository;
    }

    public Object save(@Valid Administrador adm) {
        return administradorRepository.save(adm);
    }

    public Optional<Administrador> findByLogin(@Valid String login) {
        return administradorRepository.findByLogin(login);
    }

    public Boolean existByLogin(@Valid String login) {
        return administradorRepository.existsByLogin(login);
    }

    public Page<Administrador> findAll(Pageable pageable) {
        return administradorRepository.findAll(pageable);
    }

    public Optional<List<Administrador>> findByLoginStartsWith(String login) {
        return administradorRepository.findByLoginStartsWith(login);
    }

    @Transactional
    public void deleteByLogin(UUID uuid) {
        administradorRepository.deleteById(uuid);
    }

}
