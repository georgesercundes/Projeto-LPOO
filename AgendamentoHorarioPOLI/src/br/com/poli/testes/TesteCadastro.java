package br.com.poli.testes;

import br.com.poli.sistema.Atendimento;
import br.com.poli.sistema.Cadastro;
import br.com.poli.sistema.Executar;
import br.com.poli.usuario.*;

public class TesteCadastro {
	
	public static void main (String [] args) {
		
	
		Professor prof = new Professor ("Gabriela", "08446716496","187106", "Direito");
		Aluno aluno = new Aluno("George", "07396169437", "789951", "Computação", "LPOO");
		Aluno aluno2 = new Aluno("Abner", "12345678912", "123456", "Computação", "LPOO");
		
		Atendimento atendimento = new Atendimento("Manhã", "18-06-18");
		Atendimento atendimento2 = new Atendimento("Manhã", "20-06-18");
		Atendimento atendimento3 = new Atendimento("Tarde", "22-06-18");
		
		Executar.definirAtendimento(prof, atendimento);
		Executar.definirAtendimento(prof, atendimento2);
		Executar.definirAtendimento(prof, atendimento3);
		
		Cadastro.cadastrar(aluno, aluno.getCpf());
		Cadastro.cadastrar(aluno2, aluno2.getCpf());
		


	}	
	
}
