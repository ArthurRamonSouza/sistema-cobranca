package com.haterteam.sistemacobranca.service;

import com.haterteam.sistemacobranca.repository.AlunoRepository;

public class AlunoService {

    final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    
}
