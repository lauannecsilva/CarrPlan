package com.example.plataforma_estudo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import com.example.plataforma_estudo.models.Usuario;


public interface UsuarioDao  extends JpaRepository<Usuario, Integer> {

    
    // CONSULTA SE OS DADOS DO USUÁRIO CONSTAM NO BD PARA FAZER LOGIN
	@Query("select u from Usuario u where u.email = :email and u.senha = :senha")
	Usuario efetuarLogin(String email, String senha);
    
}
