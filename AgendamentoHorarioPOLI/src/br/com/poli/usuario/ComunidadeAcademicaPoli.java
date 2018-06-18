package br.com.poli.usuario;

import java.io.Serializable;

public class ComunidadeAcademicaPoli implements Serializable {

	// Atributos da classe
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String senha;

	// Construtores da Classe
	public ComunidadeAcademicaPoli(String nome, String cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	// Setters e Getters da Classe
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

}
