package com.example.models;

import java.time.LocalDate;

public class Usuario {
    
    private Integer id;
    private String nome;
    private String genero;
    private String cpf;
    private String senha;
    private String email;
    private LocalDate dataNascimento;
    private boolean ativo;

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


    @Override
    public String toString() {
        return "usuario [ativo=" + ativo + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + email
                + ", genero=" + genero + ", id=" + id + ", nome=" + nome + ", senha=" + senha + "]";
    }
    
    

}
