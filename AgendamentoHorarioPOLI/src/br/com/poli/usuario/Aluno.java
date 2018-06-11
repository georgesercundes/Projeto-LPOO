package br.com.poli.usuario;

public class Aluno extends ComunidadeAcademicaPoli {

	// Atributos da classe
	private String curso;
	private String turma;

	// Construtor da classe com chamada para construtor da superclasse
	public Aluno(String nome, String cpf, String senha, String curso, String turma) {
		super(nome, cpf, senha);
		this.turma = turma;
		this.curso = curso;
	}

	// Setters e Getters da classe
	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getTurma() {
		return turma;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	// Representação String da Classe
	@Override
	public String toString() {
		return String.format("%s%n%s: %s%n%s: %s%n", super.toString(), "Curso", getCurso(), "Turma", getTurma());
	}

}
