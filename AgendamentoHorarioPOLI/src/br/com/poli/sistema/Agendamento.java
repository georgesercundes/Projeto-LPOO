package br.com.poli.sistema;

import java.io.Serializable;

import br.com.poli.usuario.Professor;

public class Agendamento implements Serializable {

	// Atributos da classe
	private static final long serialVersionUID = 1L;
	private Professor professorAgendado;
	private String diaDoAtendimento;
	private String horarioDoAtendimento;

	// Construtor da classe
	public Agendamento(Professor professorAgendado, String diaDoAtendimento, String horarioDoAtendimento) {
		this.professorAgendado = professorAgendado;
		this.diaDoAtendimento = diaDoAtendimento;
		this.horarioDoAtendimento = horarioDoAtendimento;
	}

	// Setters e Getters da classe
	public Professor getProfessorAgendado() {
		return professorAgendado;
	}

	public void setProfessorAgendado(Professor professorAgendado) {
		this.professorAgendado = professorAgendado;
	}

	public String getDiaDoAtendimento() {
		return diaDoAtendimento;
	}

	public void setDiaDoAtendimento(String diaDoAtendimento) {
		this.diaDoAtendimento = diaDoAtendimento;
	}

	public String getHorarioDoAtendimento() {
		return horarioDoAtendimento;
	}

	public void setHorarioDoAtendimento(String horarioDoAtendimento) {
		this.horarioDoAtendimento = horarioDoAtendimento;
	}

}
