package br.com.poli.testes;

import java.util.Scanner;

import br.com.poli.sistema.Agendamento;
import br.com.poli.usuario.Aluno;
import br.com.poli.usuario.Professor;

public class TesteAgendamento {

	public static void main(String[] args) throws Exception {
		
		int numeroAtendimento;
		Scanner input = new Scanner(System.in);
		Professor teste = new Professor ("Ivan", "12345878912", "12345", "Básico");
		Aluno aluno1 = new Aluno("George", "07396169437", "12345", "Computação", "LF");
		Aluno aluno2 = new Aluno("Pedro", "12345678985", "12345", "Civil", "MP");
		teste.setHorarioDeAtendimento("Manhã");
		System.out.print("Escolha um numero relacionado a um horario de atendimento ou -1 para sair: ");
		numeroAtendimento = input.nextInt();
		Agendamento.agendar(aluno1, teste, numeroAtendimento);
		System.out.println();
		System.out.print("Escolha um numero relacionado a um horario de atendimento ou -1 para sair: ");
		numeroAtendimento = input.nextInt();
		Agendamento.agendar(aluno2, teste, numeroAtendimento);
		System.out.println();
		System.out.println();
		System.out.print(teste.getAlunosAgendados());

	}

}
