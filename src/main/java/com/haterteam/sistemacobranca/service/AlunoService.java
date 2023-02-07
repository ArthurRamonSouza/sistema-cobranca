package com.haterteam.sistemacobranca.service;

import com.haterteam.sistemacobranca.model.Aluno;
import com.haterteam.sistemacobranca.repository.AlunoRepository;

import jakarta.transaction.Transactional;

public class AlunoService {

    final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
}
