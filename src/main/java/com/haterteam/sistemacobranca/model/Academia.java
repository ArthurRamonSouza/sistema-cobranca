package com.haterteam.sistemacobranca.model;

import java.time.LocalDate;
import java.util.List;

public class Academia {
    
    private String nome;
    private String endereco;
    private List<LocalDate> datasPagamento;
    private float mensalidade;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public List<LocalDate> getDatasPagamento() {
        return datasPagamento;
    }
    public void setDatasPagamento(List<LocalDate> datasPagamento) {
        this.datasPagamento = datasPagamento;
    }
    public float getMensalidade() {
        return mensalidade;
    }
    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }

}
