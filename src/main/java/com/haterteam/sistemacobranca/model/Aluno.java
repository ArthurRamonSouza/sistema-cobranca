package com.haterteam.sistemacobranca.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable{

    private static final long serialVersionUID = 1l;

    @Id
    private String cpf;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false)
    private int idade;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private int celular;
    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false)
    private Date dataPagamento;
    @Column(nullable = false)
    private float mensalidade;
    @Column(nullable = false)
    private Date ultimoPagamento;

    @Column(nullable = false)
    private static Date dataPagamentoPadrao;
    @Column(nullable = false)
    private static float mensalidadePadrao;

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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
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

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public float getMensalidade() {
        return mensalidade;
    }
    
    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }
    
    public Date getUltimoPagamento() {
        return ultimoPagamento;
    }

    public static Date getDataPagamentoPadrao() {
        return dataPagamentoPadrao;
    }

    public static void setDataPagamentoPadrao(Date dataPagamentoPadrao) {
        Aluno.dataPagamentoPadrao = dataPagamentoPadrao;
    }

    public static float getMensalidadePadrao() {
        return mensalidadePadrao;
    }

    public static void setMensalidadePadrao(float mensalidadePadrao) {
        Aluno.mensalidadePadrao = mensalidadePadrao;
    }

    public void realizarPagamento(){
        this.ultimoPagamento = new Date();
    }

}