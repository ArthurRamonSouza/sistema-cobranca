package com.haterteam.sistemacobranca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haterteam.sistemacobranca.dto.AdministradorDTO;
import com.haterteam.sistemacobranca.model.Administrador;
import com.haterteam.sistemacobranca.service.AdministradorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/adm")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdministradorController {

    final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService){
        this.administradorService = administradorService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAdministrador(@RequestBody @Valid Administrador adm){

        if(administradorService.existByLogin(adm.getLogin())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Este administrador já está na base de dados.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(administradorService.save(adm));
    }

    @GetMapping()
    public ResponseEntity<Page<Administrador>> getAllAdministradores(@PageableDefault(page = 0, size = 30, sort = "login", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(administradorService.findAll(pageable));
    }

    @GetMapping("/buscar/login")
    public ResponseEntity<Object> getAdministradoresByLogin(@RequestParam String login){

        Optional<List<Administrador>> administradoresOptional = administradorService.findByLoginStartsWith(login);

        if(administradoresOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum cadastro encontrado a partir desta busca.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(administradorService.findByLoginStartsWith(login));
    }

    @PutMapping("/{login}")
    public ResponseEntity<Object> updateAluno(@PathVariable(value = "login") String login, @RequestBody @Valid AdministradorDTO administradorDto){
        //If already exists an Adm with this username, the operation must be canceled
        Optional<Administrador> administradorOptional = administradorService.findByLogin(login);

        if(administradorOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador não cadastrado na base de dados.");
        }

        var adm = administradorOptional.get();
        BeanUtils.copyProperties(administradorDto, adm);
        
        administradorOptional = administradorService.findByLogin(administradorDto.getLogin());
        if(administradorOptional.isPresent() && administradorOptional.get().getLogin() != adm.getLogin()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Este usuário está associado a outro administrador.");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(administradorService.save(adm));
    }

    @DeleteMapping("/{login}")
    public ResponseEntity<Object> deleteAluno(@PathVariable(value = "login") String login){
        Optional<Administrador> administradorOptional = administradorService.findByLogin(login);

        if(administradorOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador não cadastrado na base de dados.");
        }

        administradorService.deleteByLogin(administradorOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body("Administrador excluído da base de dados.");
    }
    
}
