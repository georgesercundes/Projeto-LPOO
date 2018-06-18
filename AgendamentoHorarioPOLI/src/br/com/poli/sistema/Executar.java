package br.com.poli.sistema;

import java.util.ArrayList;
import java.util.Collections;

import br.com.poli.usuario.Aluno;
import br.com.poli.usuario.Professor;

public class Executar {

	// Método para efetuar o agendamento
	public static void efetuarAgendamento(Aluno alunoAgendamento, Professor professorAgendamento,
			String diaAtendimentoAgendamento, String horarioAgendamento) {

		// Criar um objeto de agendamento e salva-lo num arraylist de agendamentos do
		// aluno
		Agendamento agendamento = new Agendamento(professorAgendamento, diaAtendimentoAgendamento, horarioAgendamento);
		alunoAgendamento.setAgendamentos(agendamento);

		// Salvar os nomes dos alunos agendados
		// Salvar os horarios de atendimentos
		// Remover o horario de atendimento disponivel da lista
		ArrayList<Atendimento> atendimentosProfessorAgendamento = professorAgendamento.getAtendimentos();
		for (Atendimento atendimentoAgendamento : atendimentosProfessorAgendamento) {
			if (atendimentoAgendamento.getDiaDoAtendimento().equals(diaAtendimentoAgendamento)) {
				atendimentoAgendamento.setAlunosAtendimento(alunoAgendamento);
				atendimentoAgendamento.setHorariosDeAtendimentoAgendados(horarioAgendamento);
				atendimentoAgendamento.getHorariosDeAtendimentoDisponiveis().remove(horarioAgendamento);
			}

		}

		// Salvar as informações do agendamento no cadastro do Professor e do Aluno
		Cadastro.cadastrar(alunoAgendamento, alunoAgendamento.getCpf());
		Cadastro.cadastrar(professorAgendamento, professorAgendamento.getCpf());
	}

	// Método para definir o atendimento do professor
	public static void definirAtendimento(Professor professor, Atendimento atendimento) {
		atendimento.setHorariosDeAtendimentoDisponiveis();
		professor.setAtendimentos(atendimento);
		Cadastro.cadastrar(professor, professor.getCpf());
	}

	//Método para remover o agendamento
	public static void removerAgendamento(Aluno alunoAgendado, int indiceAgendamento) {
		
		Agendamento agendamento = alunoAgendado.getAgendamentos().get(indiceAgendamento);
		String cpfProfessorAgendado = agendamento.getProfessorAgendado().getCpf();
		String horarioAtendimentoAgendado = agendamento.getHorarioDoAtendimento();
		String diaDoAtendimentoAgendado = agendamento.getDiaDoAtendimento();
		Professor professorAgendado = (Professor) Cadastro.resgatarUsuarioCadastro(cpfProfessorAgendado);
		
		//Remover o horário da lista de horarios agendados
		//Adicionar de volta o horário que foi agendado para a lista de horarios disponiveis
		//Remover o aluno da lista de alunos agendados
		for (Atendimento atendimentoAgendado : professorAgendado.getAtendimentos()) {
			if (atendimentoAgendado.getDiaDoAtendimento().equals(diaDoAtendimentoAgendado)) {
				atendimentoAgendado.getHorariosDeAtendimentoAgendados().remove(horarioAtendimentoAgendado);
				atendimentoAgendado.getHorariosDeAtendimentoDisponiveis().add(horarioAtendimentoAgendado);
				Collections.sort(atendimentoAgendado.getHorariosDeAtendimentoDisponiveis());
				ArrayList<Aluno> alunosAgendados = atendimentoAgendado.getAlunosAtendimento();
				Aluno alunoRemover = new Aluno(null,null,null,null,null);
				for (Aluno aluno : alunosAgendados) {
					if (aluno.getCpf().equals(alunoAgendado.getCpf()))
						alunoRemover = aluno;
				}
				atendimentoAgendado.getAlunosAtendimento().remove(alunoRemover);
			}

		}

		// Salvar as alterações feitas no arquivo do professor agendado
		Cadastro.cadastrar(professorAgendado, cpfProfessorAgendado);

		// Remover o agendamento da lista de acompanhamento do aluno
		alunoAgendado.getAgendamentos().remove(indiceAgendamento);

		// Salvar as alterações feitas no arquivo do aluno agendado
		Cadastro.cadastrar(alunoAgendado, alunoAgendado.getCpf());
	}

	// Método para verificar se já existe atendimento definido para o dia informado
	// como parâmetro
	public static boolean jaExisteAtendimento(Professor professorAtendimento, String diaAtendimento) {
		ArrayList<Atendimento> atendimentos = professorAtendimento.getAtendimentos();
		for (Atendimento atendimento : atendimentos) {
			if (atendimento.getDiaDoAtendimento().equals(diaAtendimento))
				return true;
		}
		return false;
	}

	// Método para remover Atendimento do professor e consequentemente apagar os
	// agendamentos dos alunos relacionados a esse atendimento
	public static void removerAtendimento(Professor professorAtendimento, int indiceAtendimento) {
		Atendimento atendimentoRemover = professorAtendimento.getAtendimentos().get(indiceAtendimento);
		String diaDoAtendimentoRemover = professorAtendimento.getAtendimentos().get(indiceAtendimento)
				.getDiaDoAtendimento();
		ArrayList<Aluno> alunosAtendimento = atendimentoRemover.getAlunosAtendimento();

		// Percorrer a lista de alunos agendados do atendimento e apagar o agendamento e
		// salvar as informações sobrescrevendo o cadastro do aluno
		for (Aluno aluno : alunosAtendimento) {
			Aluno alunoCadastro = (Aluno) Cadastro.resgatarUsuarioCadastro(aluno.getCpf());
			ArrayList<Agendamento> agendamentos = alunoCadastro.getAgendamentos();
			ArrayList<Agendamento> agendamentosRemover = new ArrayList<>();

			for (Agendamento agendamento : agendamentos) {
				String diaDoAtendimentoAluno = agendamento.getDiaDoAtendimento();
				if (diaDoAtendimentoAluno.equalsIgnoreCase(diaDoAtendimentoRemover))
					agendamentosRemover.add(agendamento);
			}

			alunoCadastro.getAgendamentos().removeAll(agendamentosRemover);
			Cadastro.cadastrar(alunoCadastro, alunoCadastro.getCpf());

		}

		// Remover o atendimento e salvar as informações sobrescrevendo o cadastro do
		// professor
		professorAtendimento.getAtendimentos().remove(atendimentoRemover);
		Cadastro.cadastrar(professorAtendimento, professorAtendimento.getCpf());
	}
}
