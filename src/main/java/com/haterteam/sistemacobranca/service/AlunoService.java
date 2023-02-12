package com.haterteam.sistemacobranca.service;

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
    
}
