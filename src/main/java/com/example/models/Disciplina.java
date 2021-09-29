package com.example.models;


public class Disciplina {

    private Integer id;
    private String  nome;
    private String cronograma;
    private String sinopse;


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
    public String getCronograma() {
        return cronograma;
    }
    public void setCronograma(String cronograma) {
        this.cronograma = cronograma;
    }
    public String getSinopse() {
        return sinopse;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    @Override
    public String toString() {
        return "Disciplina [cronograma=" + cronograma + ", id=" + id + ", nome=" + nome + ", sinopse=" + sinopse + "]";
    }

    
    

    
}
