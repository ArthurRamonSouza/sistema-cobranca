package com.haterteam.sistemacobranca.dto;

import java.time.LocalDate;
import java.util.Date;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AlunoDTO {

    @NotBlank
    private String cpf;
    @NotBlank
    private String nome;
    @NotNull
    private int idade;
    @Nullable
    private String email;
    @NotNull
    @Size(max = 11)
    private String celular;
    @NotBlank
    @Size(max = 8)
    private String cep;
    @NotNull
    private float mensalidade;
    @NotNull
    private Date dataPagamento;
    
    private LocalDate ultimoPagamento;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getUltimoPagamento() {
        return ultimoPagamento;
    }

    public void setUltimoPagamento(LocalDate ultimoPagamento) {
        this.ultimoPagamento = ultimoPagamento;
    }

    

}