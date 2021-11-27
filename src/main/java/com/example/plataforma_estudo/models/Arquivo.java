package com.example.plataforma_estudo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Arquivo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_arquivo;

	@NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String caminho;
   
}