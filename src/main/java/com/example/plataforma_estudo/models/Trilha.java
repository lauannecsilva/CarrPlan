package com.example.plataforma_estudo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Trilha {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_trilha;

    @NotBlank(message = "Campo obrigatorio")
    @Column(length = 255, nullable = false)
    private String  nome;

    // @NotBlank(message = "Campo obrigatorio")
    @Column(length = 255, nullable = false)
    private String textoApresentacao;

    @NotBlank(message = "Campo obrigatorio")
    @Column(length = 255, nullable = false)
    private String conteudoProgramatico;

    @NotBlank(message = "Campo obrigatorio")
    @Column(length = 50, nullable = false)
    private String nivel;

    @NotBlank(message = "Campo obrigatorio")
    @Column(length = 255, nullable = false)
    private String categoria;

    public Integer getId_trilha() {
        return id_trilha;
    }

    public void setId_trilha(Integer id_trilha) {
        this.id_trilha = id_trilha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getConteudoProgramatico() {
        return conteudoProgramatico;
    }

    public void setConteudoProgramatico(String conteudoProgramatico) {
        this.conteudoProgramatico = conteudoProgramatico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTextoApresentacao() {
        return textoApresentacao;
    }

    public void setTextoApresentacao(String textoApresentacao) {
        this.textoApresentacao = textoApresentacao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
   
    
    
}
