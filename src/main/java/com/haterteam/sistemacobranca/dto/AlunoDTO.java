package com.haterteam.sistemacobranca.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @Nullable
    private String sexo;
    @NotBlank
    @Size(max = 11)
    private String celular;
    @NotBlank
    @Size(max = 8)
    private String cep;
    @NotBlank
    private String mensalidadeStr;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataPagamento;
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
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getSexo() {
        return sexo;
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
        return Float.parseFloat(mensalidadeStr);
    }
    public void setMensalidadeStr(String mensalidadeStr) {
        this.mensalidadeStr = mensalidadeStr;
    }
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public LocalDate getUltimoPagamento() {
        return ultimoPagamento;
    }
    public void setUltimoPagamento(LocalDate ultimoPagamento) {
        this.ultimoPagamento = ultimoPagamento;
    }

}