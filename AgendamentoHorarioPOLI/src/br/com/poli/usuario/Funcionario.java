package br.com.poli.usuario;

public class Funcionario extends ComunidadeAcademicaPoli {

	// Atributos da classe
	private String cargo;
	private static final long serialVersionUID = 1L;

	// Construtor da classe com chamada para construtor da superclasse
	public Funcionario(String nome, String cpf, String senha, String cargo) {
		super(nome, cpf, senha);
		this.cargo = cargo;
	}

	// Setters e Getters da Classe
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
