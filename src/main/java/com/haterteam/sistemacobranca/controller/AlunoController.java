package com.haterteam.sistemacobranca.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haterteam.sistemacobranca.dto.AlunoDTO;
import com.haterteam.sistemacobranca.model.Aluno;
import com.haterteam.sistemacobranca.repository.AlunoRepository;
import com.haterteam.sistemacobranca.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/aluno")
public class AlunoController {

    final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @PostMapping
    public ResponseEntity<Object> saveAluno(@RequestBody @Valid AlunoDTO alunoDto){
        var aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto, aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));

    }
    
}
