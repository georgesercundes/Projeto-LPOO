package br.com.poli.usuario;

import java.util.ArrayList;

public class Professor extends ComunidadeAcademicaPoli {

	// Atributos da classe
	private String cursoCoordenacao;
	ArrayList<String> horarioDeAtendimento = new ArrayList<>();
	ArrayList<Aluno> alunosAgendados = new ArrayList<>();
	private final int numeroDeHorariosDeAtendimento = 8;

	// Construtor da classe com chamada para construtor da superclasse
	public Professor(String nome, String cpf, String senha, String cursoCoordenação) {
		super(nome, cpf, senha);
		this.cursoCoordenacao = cursoCoordenação;
	}

	// Setters e Getters da classe
	public void setcursoCoordenacao(String cursoCoordenacao) {
		this.cursoCoordenacao = cursoCoordenacao;
	}

	public String getcursoCoordenacao() {
		return cursoCoordenacao;
	}

	public void setAlunosAgendados(Aluno alunoAgendado) {
		alunosAgendados.add(alunoAgendado);
	}

	public ArrayList<Aluno> getAlunosAgendados() {
		return alunosAgendados;
	}

	public ArrayList<String> getHorarioDeAtendimento() {
		return horarioDeAtendimento;
	}

	// Método para formatar os horários de atendimento do professor
	public void setHorarioDeAtendimento(String turno) {
		int hora, minuto, hora2, minuto2;
		String horarioFormatado;
		if (turno.equalsIgnoreCase("Manhã")) {
			hora = 8;
			minuto = 0;
			hora2 = 8;
			minuto2 = 30;
			for (int count = 0; count < numeroDeHorariosDeAtendimento; count++) {
				horarioFormatado = String.format("%02d:%02d às %02d:%02d", hora, minuto, hora2, minuto2);
				horarioDeAtendimento.add(horarioFormatado);
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

		if (turno.equalsIgnoreCase("Tarde")) {
			hora = 13;
			minuto = 0;
			hora2 = 13;
			minuto2 = 30;
			for (int count = 0; count < numeroDeHorariosDeAtendimento; count++) {
				horarioFormatado = String.format("%02d:%02d às %02d:%02d", hora, minuto, hora2, minuto2);
				horarioDeAtendimento.add(horarioFormatado);
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

	// Representação em String da Classe
	@Override
	public String toString() {
		return String.format("%s%n%s: %s%n", super.toString(), "Coordenação", getcursoCoordenacao());
	}

	// Representação em String customizada dos arrayslists

	public String horariodeAtendimentoToString() {
		String horarioToString = String.format("%s%n", "Horário de Atendimento: ");
		for (String horarios : horarioDeAtendimento)
			horarioToString = String.format("%s%n%s", horarioToString, horarios);

		return horarioToString;
	}

	public String alunosAgendadosToString() {
		String alunosToString = String.format("%s%n", "Alunos Agendados: ");
		for (Aluno alunos : alunosAgendados)
			alunosToString = String.format("%s%n%s", alunosToString, alunos);

		return alunosToString;
	}

}
