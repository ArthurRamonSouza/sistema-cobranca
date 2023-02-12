package com.haterteam.sistemacobranca.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haterteam.sistemacobranca.dto.AlunoDTO;
import com.haterteam.sistemacobranca.model.Aluno;
import com.haterteam.sistemacobranca.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/aluno")
public class AlunoController {

    final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping("")
	public String index(){
        return "Aluno Home";
    }

    
    @PostMapping
    public ResponseEntity<Object> saveAluno(@RequestBody @Valid AlunoDTO alunoDto){

        if(alunoService.existsByCpf(alunoDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Este CPF já está cadastrado na base de dados.");
        }

        if(alunoService.existsByNome(alunoDto.getNome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Este nome já está cadastrado na base de dados.");
        }

        var aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto, aluno);
        aluno.setMensalidade(alunoDto.getMensalidadeStr());
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));

    }
    
}