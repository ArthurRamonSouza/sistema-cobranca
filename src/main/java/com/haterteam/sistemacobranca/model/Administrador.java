package com.haterteam.sistemacobranca.model;

import java.util.Date;

public class Administrador {

    private String nome;
    private String senha;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDataPagamentoPadrao(Date data){
        Aluno.setDataPagamentoPadrao(data);
    }

    public void setMensalidadePadrao(float valor){
        Aluno.setMensalidadePadrao(valor);
    }
}