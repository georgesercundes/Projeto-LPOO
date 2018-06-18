package br.com.poli.usuario;

import java.util.ArrayList;

import br.com.poli.sistema.Agendamento;

public class Aluno extends ComunidadeAcademicaPoli {

	// Atributos da classe
	private static final long serialVersionUID = 1L;
	private String curso;
	private String turma;
	private ArrayList<Agendamento> agendamentos = new ArrayList<>();

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

	public void setAgendamentos(Agendamento agendamento) {
		agendamentos.add(agendamento);
	}

	public ArrayList<Agendamento> getAgendamentos() {
		return agendamentos;
	}

}
