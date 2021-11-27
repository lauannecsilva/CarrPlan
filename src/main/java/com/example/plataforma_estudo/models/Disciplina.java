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
    private Integer id_disciplina;

    @Column(length = 255, nullable = false)
    private String  nome;

    @Column(length = 255, nullable = false)
    private String cronograma;

    @Column(length = 255, nullable = false)
    private String sinopse;

    
    private String nivel;
   
    

    


    
    
    

    
}
