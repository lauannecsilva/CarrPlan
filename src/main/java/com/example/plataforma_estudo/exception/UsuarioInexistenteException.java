package com.example.plataforma_estudo.exception;

public class UsuarioInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UsuarioInexistenteException(String mensagem) {
		super(mensagem);
	}

}
