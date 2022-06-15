package com.example.plataforma_estudo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum TipoUsuario {

	ALUNO("Aluno"), ADMINISTRADOR("Administrador");

	@Id
	private final String displayValue;

	private TipoUsuario(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
}
