package com.example.plataforma_estudo.models;

import javax.persistence.Entity;


public class Role{
    
    private Integer id;
    private String nome_grupo;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getnome_grupo() {
        return nome_grupo;
    }
    public void setnome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }
    @Override
    public String toString() {
        return "Role [id=" + id + ", nome_grupo=" + nome_grupo + "]";
    }
    

}
