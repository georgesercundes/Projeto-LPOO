package br.com.poli.testes;

import java.util.ArrayList;
import br.com.poli.sistema.Agendamento;
import br.com.poli.sistema.Executar;
import br.com.poli.sistema.Atendimento;
import br.com.poli.sistema.Cadastro;
import br.com.poli.usuario.Aluno;
import br.com.poli.usuario.Professor;

public class TesteRemoverAgendamento {
	
	public static void main (String[] args) {
		
		Aluno aluno3 = (Aluno) Cadastro.resgatarUsuarioCadastro("07396169437");
		Executar.removerAgendamento(aluno3, 3);
		
	
		Professor prof = (Professor) Cadastro.resgatarUsuarioCadastro("08446716496");
		ArrayList <Agendamento> agendamentosAluno = aluno3.getAgendamentos();
		ArrayList<Atendimento> atendimentosProf = prof.getAtendimentos();
		
		for(int counter = 0; counter < agendamentosAluno.size(); counter++) 
			System.out.printf("Dia %s: Professor: %s - Horario: %s%n", agendamentosAluno.get(counter).getDiaDoAtendimento(), agendamentosAluno.get(counter).getProfessorAgendado().getNome(), 
					agendamentosAluno.get(counter).getHorarioDoAtendimento());

		System.out.println();
		
		for(Atendimento atendimento: atendimentosProf)
			System.out.println(atendimento.getDiaDoAtendimento());
		
		System.out.println();
		
		ArrayList <String> horariosAgendadosTeste = prof.getAtendimentos().get(0).getHorariosDeAtendimentoDisponiveis();
		for(String horarioMostrarTeste : horariosAgendadosTeste)
			System.out.println(horarioMostrarTeste);
	
	}
}
