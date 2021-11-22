package com.example.plataforma_estudo.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disciplina {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false)
    private String  nome;

    @Column(length = 255, nullable = false)
    private String cronograma;

    @Column(length = 255, nullable = false)
    private String sinopse;

    @Embedded
    private Topicos topicos;

    


    public Topicos getTopicos() {
        return topicos;
    }
    public void setTopicos(Topicos topicos) {
        this.topicos = topicos;
    }
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
