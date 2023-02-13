package com.haterteam.sistemacobranca.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        aluno.setMensalidade(alunoDto.getMensalidade());
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));

    }

    @GetMapping
    public ResponseEntity<Page<Aluno>> getAllAlunos(@PageableDefault(page = 0, size = 30, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAluno(@PathVariable(value = "id") UUID id){
        Optional<Aluno> alunoOptional = alunoService.findById(id);

        if(!alunoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não cadastrado na base de dados.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(alunoOptional.get());
    }

    @GetMapping("/buscar/{termo}")
    public ResponseEntity<Object> getAlunoByNome(@PathVariable(value = "termo") String termo){
        Optional<List<Aluno>> alunosOptional = alunoService.findByNomeStartsWith(termo);

        if(alunosOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum cadastro encontrado a partir desta busca.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(alunosOptional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAluno(@PathVariable(value = "id") UUID id, @RequestBody @Valid AlunoDTO alunoDto){
        Optional<Aluno> alunoOptional = alunoService.findById(id);

        if(!alunoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não cadastrado na base de dados.");
        }

        var aluno = alunoOptional.get();

        alunoOptional = alunoService.findByCpf(alunoDto.getCpf());
        if(alunoOptional.isPresent() && alunoOptional.get().getNome() != aluno.getNome()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CPF está associado a outro aluno.");
        }
        aluno.setCpf(alunoDto.getCpf());

        alunoOptional = alunoService.findByNome(alunoDto.getNome());
        if(alunoOptional.isPresent() && alunoOptional.get().getNome() != aluno.getNome()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Nome do aluno já está presente na base de dados.");
        }
        aluno.setNome(alunoDto.getNome());

        aluno.setIdade(alunoDto.getIdade());
        aluno.setEmail(alunoDto.getEmail());
        aluno.setCelular(alunoDto.getCelular());
        aluno.setCep(alunoDto.getCep());
        aluno.setMensalidade(alunoDto.getMensalidade());
        aluno.setDataPagamento(alunoDto.getDataPagamento());
        aluno.setUltimoPagamento(alunoDto.getUltimoPagamento());
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAluno(@PathVariable(value = "id") UUID id){
        Optional<Aluno> alunoOptional = alunoService.findById(id);

        if(!alunoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não cadastrado na base de dados.");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Aluno excluído da base de dados.");
    }

}