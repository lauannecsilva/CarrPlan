package com.example.plataforma_estudo.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Disciplina {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_disciplina;

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
    private String valor;

    @NotBlank(message = "Campo obrigatorio")
    @Column(length = 255, nullable = false)
    private String categoria;

    public Integer getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Integer id_disciplina) {
        this.id_disciplina = id_disciplina;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
   
    
    
}
