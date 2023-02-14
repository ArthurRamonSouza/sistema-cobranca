package com.haterteam.sistemacobranca.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable{

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false)
    private int idade;
    @Column(nullable = false)
    private String sexo;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 11)
    private String celular;
    @Column(nullable = false, length = 8)
    private String cep;
    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataPagamento;
    @Column(nullable = false)
    private float mensalidade;
    @Column(nullable = true)
    private LocalDate ultimoPagamento;
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setUltimoPagamento(LocalDate ultimoPagamento) {
        this.ultimoPagamento = ultimoPagamento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public float getMensalidade() {
        return mensalidade;
    } 
    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }
    public LocalDate getUltimoPagamento() {
        return ultimoPagamento;
    }
    public void realizarPagamento(){
        this.ultimoPagamento = LocalDate.now();
    }

}