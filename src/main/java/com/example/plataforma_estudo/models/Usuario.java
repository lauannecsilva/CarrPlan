package com.example.plataforma_estudo.models;

import java.time.LocalDate;

/*import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;*/
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Nome é necessário")
	@Column(length = 255, nullable = false)
	private String nome;

	@Column(length = 14, nullable = false)
	private String cpf;

	@Column(length = 255, nullable = false)
	private String senha;

	@Email(message = "Email inválido")
	@NotEmpty(message = "Email é necessário")
	@Column(length = 255, nullable = false)
	private String email;

	@NotNull(message = "Data de Nascimento é necessária")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "Deve ser uma data de nascimento anterior a data atual")
	@Column(name = "data_nasc")
	private LocalDate dataNascimento;
	
	@Column(name = "tipoUsuario")
	@Enumerated(EnumType.STRING)//para dizer como vai ser salvo no banco
	private TipoUsuario tipoUsuario;
	
	
	

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
