package com.example.plataforma_estudo.service;



import com.example.plataforma_estudo.dao.TrilhaDao;
import com.example.plataforma_estudo.models.Trilha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrilhaService {
    @Autowired
    private TrilhaDao trilhaDao;

    public void save(Trilha trilha){
        this.trilhaDao.save(trilha);
    }

    public Iterable<Trilha> list(){
        Iterable<Trilha> trilha = this.trilhaDao.findAll();
        return trilha;
    }

    public Trilha search(Integer id){
        return this.trilhaDao.findById(id).get();
    }

    public void delete(Integer id){
        this.trilhaDao.deleteById(id);
    }

    public void update(Trilha trilha){
        System.out.println("aquiii");
        this.trilhaDao.findById(trilha.getId_trilha()).get();
        trilha.setNome(trilha.getNome());
        this.trilhaDao.save(trilha);
    }
}
