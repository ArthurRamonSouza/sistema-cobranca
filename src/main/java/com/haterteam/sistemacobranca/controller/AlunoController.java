package com.haterteam.sistemacobranca.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haterteam.sistemacobranca.service.AlunoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/aluno")
public class AlunoController {

    final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    
}
