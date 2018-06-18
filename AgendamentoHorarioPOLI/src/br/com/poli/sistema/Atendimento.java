package br.com.poli.sistema;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.poli.usuario.Aluno;

public class Atendimento implements Serializable {

	// Atributos da classe
	private static final long serialVersionUID = 1L;
	private String diaDoAtendimento;
	private String turnoDeAtendimento;
	private int numeroDeAtendimentos = 8;
	private ArrayList<String> horariosDeAtendimentoDisponiveis = new ArrayList<>();
	private ArrayList<String> horariosDeAtendimentoAgendados = new ArrayList<>();
	private ArrayList<Aluno> alunosAtendimento = new ArrayList<>();

	//Construtor da classe 
	public Atendimento(String turnoDoAtendimento, String diaDoAtendimento) {
		this.turnoDeAtendimento = turnoDoAtendimento;
		this.diaDoAtendimento = diaDoAtendimento;
	}

	// Setters e Getters da classe
	public ArrayList<String> getHorariosDeAtendimentoDisponiveis() {
		return horariosDeAtendimentoDisponiveis;
	}

	public void setHorariosDeAtendimentoDisponiveis() {
		int hora, minuto, hora2, minuto2;
		if (getTurnoDeAtendimento().equalsIgnoreCase("Manhã")) {
			hora = 8;
			minuto = 0;
			hora2 = 8;
			minuto2 = 30;
			for (int count = 0; count < numeroDeAtendimentos; count++) {
				horariosDeAtendimentoDisponiveis
						.add(String.format("%02d:%02d às %02d:%02d", hora, minuto, hora2, minuto2));
				minuto += 30;
				minuto2 += 30;

				if (minuto2 == 60) {
					hora2 += 1;
					minuto2 = 0;
				}

				if (minuto == 60) {
					hora += 1;
					minuto = 0;
				}
			}
		}

		if (getTurnoDeAtendimento().equalsIgnoreCase("Tarde")) {
			hora = 13;
			minuto = 0;
			hora2 = 13;
			minuto2 = 30;
			for (int count = 0; count < numeroDeAtendimentos; count++) {
				horariosDeAtendimentoDisponiveis
						.add(String.format("%02d:%02d às %02d:%02d", hora, minuto, hora2, minuto2));
				minuto += 30;
				minuto2 += 30;

				if (minuto2 == 60) {
					hora2 += 1;
					minuto2 = 0;
				}

				if (minuto == 60) {
					hora += 1;
					minuto = 0;
				}
			}
		}
	}

	public ArrayList<Aluno> getAlunosAtendimento() {
		return alunosAtendimento;
	}

	public void setAlunosAtendimento(Aluno alunoAtendimento) {
		alunosAtendimento.add(alunoAtendimento);
	}

	public ArrayList<String> getHorariosDeAtendimentoAgendados() {
		return horariosDeAtendimentoAgendados;
	}

	public void setHorariosDeAtendimentoAgendados(String horarioDeAtendimentoAgendado) {
		horariosDeAtendimentoAgendados.add(horarioDeAtendimentoAgendado);
	}

	public String getDiaDoAtendimento() {
		return diaDoAtendimento;
	}

	public void setDiaDoAtendimento(String diaDoAtendimento) {
		this.diaDoAtendimento = diaDoAtendimento;
	}

	public String getTurnoDeAtendimento() {
		return turnoDeAtendimento;
	}

	public void setTurnoDeAtendimento(String turnoDeAtendimento) {
		this.turnoDeAtendimento = turnoDeAtendimento;
	}

}
