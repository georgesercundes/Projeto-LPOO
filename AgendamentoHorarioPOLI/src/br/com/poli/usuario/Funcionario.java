package br.com.poli.usuario;

public class Funcionario extends ComunidadeAcademicaPoli {

	// Atributos da classe
	private String cargo;

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

	// Representação String da Classe
	@Override
	public String toString() {
		return String.format("%s%n%s: %s%n", super.toString(), "Cargo", getCargo());
	}

}
