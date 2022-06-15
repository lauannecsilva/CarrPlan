package com.example.plataforma_estudo.dao;

import com.example.plataforma_estudo.models.Trilha;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrilhaDao extends CrudRepository<Trilha, Integer>{
    
}
