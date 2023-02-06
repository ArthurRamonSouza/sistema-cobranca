package com.haterteam.sistemacobranca.model;

import java.util.Date;

public class Aluno {

    private String nome;
    private int idade;
    private String email;
    private int celular;
    private String cep;
    private String cpf;

    private Date dataPagamento;
    private float mensalidade;
    private Date ultimoPagamento;

    private static Date dataPagamentoPadrao;
    private static float mensalidadePadrao;

    public Aluno(String nome, int idade, int celular, String cep, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.celular = celular;
        this.cep = cep;
        this.cpf = cpf;
    }

    public Aluno(String nome, int idade, String email, int celular, String cep, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.celular = celular;
        this.cep = cep;
        this.cpf = cpf;
    }

    public Aluno(String nome, int idade, String email, int celular, String cep, String cpf, Date dataPagamento,
            float mensalidade) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.celular = celular;
        this.cep = cep;
        this.cpf = cpf;
        this.dataPagamento = dataPagamento;
        this.mensalidade = mensalidade;
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