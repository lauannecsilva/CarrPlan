package com.example.plataforma_estudo.models;




public class Permissoes{
    
    private Integer id_permissao;

    private String nome;

    public Integer getid_permissao() {
        return id_permissao;
    }
    public void setId(Integer id_permissao) {
        this.id_permissao = id_permissao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Permissoes [id_permissao=" + id_permissao + ", nome=" + nome + "]";
    }

    

}
    

