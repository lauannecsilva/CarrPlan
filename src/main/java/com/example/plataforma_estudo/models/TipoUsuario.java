package com.example.plataforma_estudo.models;

public enum TipoUsuario {

	ALUNO("Aluno"), PROFESSOR("Professor");

	private final String displayValue;

	private TipoUsuario(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
}
