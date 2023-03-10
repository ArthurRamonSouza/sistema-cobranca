package com.haterteam.sistemacobranca.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.haterteam.sistemacobranca.model.Aluno;
import com.haterteam.sistemacobranca.repository.AlunoRepository;

import jakarta.transaction.Transactional;

@Service
public class AlunoService {

    final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public boolean existsByCpf(String cpf) {
        return alunoRepository.existsByCpf(cpf);
    }

    public boolean existsByNome(String nome) {
        return alunoRepository.existsByNome(nome);
    }

    public Page<Aluno> findAll(Pageable pageable) {
        return alunoRepository.findAll(pageable);
    }

    public Optional<Aluno> findById(UUID id) {
        return alunoRepository.findById(id);
    }

    public Optional<Aluno> findByCpf(String cpf) {
        return alunoRepository.findByCpf(cpf);
    }

    public Optional<Aluno> findByNome(String nome) {
        return alunoRepository.findByNome(nome);
    }

    public Optional<List<Aluno>> findByNomeStartsWith(String termo) {
        return alunoRepository.findByNomeStartsWith(termo);
    }

    public Optional<List<Aluno>> findAllBySexo(String sexo) {
        return alunoRepository.findAllBySexo(sexo);
    }
    
}