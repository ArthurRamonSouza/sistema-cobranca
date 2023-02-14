package com.haterteam.sistemacobranca.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.haterteam.sistemacobranca.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID>{

    boolean existsByCpf(String cpf);

    boolean existsByNome(String nome);

    Optional<Aluno> findByCpf(String cpf);

    Optional<Aluno> findByNome(String nome);

    //@Query("SELECT nome FROM alunos WHERE nome LIKE :termo%")
    Optional<List<Aluno>> findByNomeStartsWith(String termo);

    Optional<List<Aluno>> findAllBySexo(String sexo);

}