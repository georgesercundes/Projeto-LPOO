package br.com.poli.usuario;

public class ComunidadeAcademicaPoli {

	// Atributos da classe
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

	// Representação String da Classe
	public String toString() {
		return String.format("%s: %s%n%s: %s%n%s: %s", "Nome", getNome(), "CPF", getCpf(), "Senha", getSenha());
	}

}
