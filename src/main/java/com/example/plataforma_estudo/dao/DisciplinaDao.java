package com.example.plataforma_estudo.dao;

import com.example.plataforma_estudo.models.Disciplina;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaDao extends CrudRepository<Disciplina, Integer>{
    
}
