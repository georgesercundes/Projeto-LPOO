package br.com.poli.testes;

import java.util.ArrayList;

import br.com.poli.sistema.Executar;
import br.com.poli.sistema.Atendimento;
import br.com.poli.sistema.Cadastro;
import br.com.poli.usuario.Aluno;
import br.com.poli.usuario.ComunidadeAcademicaPoli;
import br.com.poli.usuario.Professor;

public class TesteAgendar {

	public static void main(String[] args) {
		
		Aluno aluno3 = (Aluno) Cadastro.resgatarUsuarioCadastro("07396169437");
		ArrayList <Professor> Professores = Cadastro.listaProfessoresCadastrados();
		
		for(Professor professor: Professores) {
			System.out.printf("%d: %s%n",Professores.indexOf(professor), professor.getNome());
		}
		System.out.println();
		
		Professor professorescolhido = Professores.get(0);
		for(Atendimento atendimentoTeste : professorescolhido.getAtendimentos()) 
			System.out.printf("%d: %s%n",professorescolhido.getAtendimentos().indexOf(atendimentoTeste), atendimentoTeste.getDiaDoAtendimento());
		
		System.out.println();
		
		int indiceAtendimentoAgendamento = 0;
		Atendimento atendimentoAgendamento = professorescolhido.getAtendimentos().get(indiceAtendimentoAgendamento);
		ArrayList<String> horariosAtendimento = atendimentoAgendamento.getHorariosDeAtendimentoDisponiveis();
		System.out.println();
		
		for(String horario: horariosAtendimento) {
			System.out.printf("%d: %s%n", horariosAtendimento.indexOf(horario) ,horario);
		}
		System.out.println();
		
		int indiceHorarioAgendamento = 6;
		
		String diaAtendimentoAgendamento = atendimentoAgendamento.getDiaDoAtendimento();
		String horarioAtendimentoAgendamento = atendimentoAgendamento.getHorariosDeAtendimentoDisponiveis().get(indiceHorarioAgendamento);
		Executar.efetuarAgendamento(aluno3, professorescolhido, diaAtendimentoAgendamento, horarioAtendimentoAgendamento);
		
		Professor mostrarResultados = (Professor) Cadastro.resgatarUsuarioCadastro(professorescolhido.getCpf());
		ArrayList <String> horariosDisponiveisTeste = mostrarResultados.getAtendimentos().get(indiceAtendimentoAgendamento).getHorariosDeAtendimentoDisponiveis();
		for(String horarioMostrarTeste : horariosDisponiveisTeste)
			System.out.println(horarioMostrarTeste);
		
		System.out.println();
		
		ArrayList<Aluno> AlunosAgendamentoTeste = mostrarResultados.getAtendimentos().get(indiceAtendimentoAgendamento).getAlunosAtendimento();
		ArrayList <String> horariosAgendadosTeste = mostrarResultados.getAtendimentos().get(indiceAtendimentoAgendamento).getHorariosDeAtendimentoAgendados();
		for(int counter = 0; counter < horariosAgendadosTeste.size(); counter++)
			System.out.printf("%s : Aluno Agendado - %s", horariosAgendadosTeste.get(counter), AlunosAgendamentoTeste.get(counter).getNome());
	
	}

}
