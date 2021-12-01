package com.example.plataforma_estudo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.plataforma_estudo.dao.DisciplinaDao;
import com.example.plataforma_estudo.models.Disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaDao disciplinaDao;

    public void save(Disciplina disciplina){
        this.disciplinaDao.save(disciplina);
    }

    public Iterable<Disciplina> list(){
        Iterable<Disciplina> disciplina = this.disciplinaDao.findAll();
        return disciplina;
    }

    public Disciplina search(Integer id){
        return this.disciplinaDao.findById(id).get();
    }

    public void delete(Integer id){
        this.disciplinaDao.deleteById(id);
    }

    public void update(Disciplina disciplina){
        System.out.println("aquiii");
        this.disciplinaDao.findById(disciplina.getId_disciplina()).get();
        disciplina.setNome(disciplina.getNome());
        this.disciplinaDao.save(disciplina);
    }
}
