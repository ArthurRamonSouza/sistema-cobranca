package com.haterteam.sistemacobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haterteam.sistemacobranca.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String>{

    boolean existsByCpf(String cpf);

    boolean existsByNome(String nome);

}
