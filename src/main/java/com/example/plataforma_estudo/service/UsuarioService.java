package com.example.plataforma_estudo.service;




import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import com.example.plataforma_estudo.dao.UsuarioDao;
import com.example.plataforma_estudo.exception.UsuarioInexistenteException;
import com.example.plataforma_estudo.exception.UsuarioInvalidoException;
import com.example.plataforma_estudo.models.Usuario;

@Service
//@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioService {
    
    @Autowired
	private UsuarioDao usuarioDao;
    
    // vai de 4 à 31 (o padrão do gensalt() é 10)
 	private static final int complexidadeSenha = 10;

    //para salvar o usuario
    public Usuario save(Usuario usuario) {
        return this.usuarioDao.save(usuario);
    }
    
    public Usuario entrar(String email, String senha) throws UsuarioInvalidoException, UsuarioInexistenteException {
		if (Strings.isBlank(email)) {
			throw new UsuarioInvalidoException("Insira o e-mail.");
		}
		if (Strings.isBlank(senha)) {
			throw new UsuarioInvalidoException("Insira a senha.");
		}

		// busca no banco o usuário com o e-mail fornecido
		Optional<Usuario> usuario = this.usuarioDao.findByEmail(email);
		
		if (usuario.isPresent()) {
			// se a senha estiver correta...
			if (BCrypt.checkpw(senha, usuario.get().getSenha())) {
				return usuario.get();
			} else {
				throw new UsuarioInexistenteException("E-mail e/ou senha inválidos.");
			}
		} else {
			throw new UsuarioInexistenteException("E-mail e/ou senha inválidos.");
		}
	}
    
    public String criptografarSenha(String senha) {
		return BCrypt.hashpw(senha, BCrypt.gensalt(complexidadeSenha));
	}
    
}
