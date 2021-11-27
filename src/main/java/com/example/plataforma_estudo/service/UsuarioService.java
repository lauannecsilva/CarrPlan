package com.example.plataforma_estudo.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import com.example.plataforma_estudo.dao.UsuarioDao;
import com.example.plataforma_estudo.models.Usuario;

@Service
//@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioService {
    
    @Autowired
	private UsuarioDao usuarioDao;

    //para salvar o usuario
    public Usuario save(Usuario usuario){
    	
    	
    	
        return this.usuarioDao.save(usuario);
    }

    
    
  
}
