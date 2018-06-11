package br.com.poli.sistema;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import br.com.poli.usuario.ComunidadeAcademicaPoli;
import br.com.poli.usuario.Professor;

public class Cadastro {

	private static BufferedWriter saida;
	private static Scanner entrada;
	private static String nomeArquivoListaProfessores = "Professores";
	private static String nomeArquivoListaAtendimento = "Atendimento";
	private static String nomeArquivoListaAlunosAgendados = "AlunosAgendados";

	// M�todo para Cadastrar o usu�rio em um arquivo txt com o nome do arquivo sendo o cpf
	// Se for professor adicionar o nome em outro cadastro com uma listagem dos professores
	public static void cadastrarUsuario(ComunidadeAcademicaPoli usuarioCadastro, String cpf) {
		
		abrirArquivoNovo(cpf);
		adicionarDados(usuarioCadastro.toString());
		fecharArquivo();
		
		if (usuarioCadastro instanceof Professor) {
			if (Cadastro.verificarCadastroExistente(nomeArquivoListaProfessores)) {
				if(Cadastro.verificarSeEstaContido(nomeArquivoListaProfessores, usuarioCadastro.getNome()) == false){
					abrirArquivoExistente(nomeArquivoListaProfessores);
					adicionarDados(usuarioCadastro.getNome());
					fecharArquivo();	
				}
				
			} 
			
			else {
				abrirArquivoNovo(nomeArquivoListaProfessores);
				adicionarDados(usuarioCadastro.getNome());
				fecharArquivo();
			}

		}
	}

	// M�todo para verificar se o par�metro est� contido no arquivo
	public static boolean verificarSeEstaContido(String nomeArquivo, String palavra) {
		abrirArquivoLeitura(nomeArquivo);
		boolean palavraExiste = lerPalavraCadastro(palavra);
		fecharArquivo();
		return palavraExiste;
	}

	//M�todo para mostrar conteudo de um arquivo
	public static String ConteudoArquivo(String nomeArquivo) {
		abrirArquivoLeitura(nomeArquivo);
		String dados = lerTodosDadosArquivo();
		fecharArquivo();
		return dados;
	}

	// M�todo para cadastrar o horario de atendimento num arquivo
	public static void cadastrarHorarioDeAtendimento(Professor cadastroAtendimento, String nome) {
		abrirArquivoNovo(nome + nomeArquivoListaAtendimento);
		adicionarDados(cadastroAtendimento.horariodeAtendimentoToString());
		fecharArquivo();
	}

	// M�todo para cadastrar os alunos agendados num arquivo
	public static void cadastrarAlunosAgendados(Professor cadastroAlunosAgendados, String nome) {
		if (Cadastro.verificarCadastroExistente(nome + nomeArquivoListaAlunosAgendados)) {
			abrirArquivoExistente(nome + nomeArquivoListaAlunosAgendados);
			adicionarDados(cadastroAlunosAgendados.alunosAgendadosToString());
			fecharArquivo();
		} else {
			abrirArquivoNovo(nome + nomeArquivoListaAlunosAgendados);
			adicionarDados(cadastroAlunosAgendados.alunosAgendadosToString());
			fecharArquivo();
		}
	}
	
	public static String procurarPalavra(String nomeArquivo, String palavraAntecedente) {
		abrirArquivoLeitura(nomeArquivo);
		String palavra = acharDadoArquivo(palavraAntecedente);
		fecharArquivo();
		return palavra;
	}

	// M�todo para abrir o arquivo existente do cadastro
	private static void abrirArquivoExistente(String nomeArquivo) {
		try {
			saida = new BufferedWriter(new FileWriter(nomeArquivo + ".txt", true));
		} catch (SecurityException e) {
			System.err.println("Permiss�o Negada");
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo n�o encontrado");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo");
			System.exit(1);
		}
	}

	// M�todo para abrir arquivo novo
	private static void abrirArquivoNovo(String nomeArquivo) {
		try {
			saida = new BufferedWriter(new FileWriter(nomeArquivo + ".txt"));
		} catch (SecurityException e) {
			System.err.println("Permiss�o Negada");
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo n�o encontrado");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo");
			System.exit(1);
		}
	}

	// M�todo para abrir o arquivo para leitura
	private static void abrirArquivoLeitura(String nomeArquivo) {
		try {
			entrada = new Scanner(Paths.get(nomeArquivo + ".txt"));
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo");
			System.exit(1);
		}
	}

	// M�todo para adicionar os dados no arquivo
	private static void adicionarDados(String dados) {
		try {
			saida.write(dados);
			saida.newLine();
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo");
			System.exit(1);
		}

	}

	// M�todo para retornar todo o conte�do do arquivo
	private static String lerTodosDadosArquivo() {
		String dados = entrada.nextLine();
		while (entrada.hasNext()) {
			dados = String.format("%s%n%s", dados, entrada.nextLine());
		}
		return dados;
	}
	
	private static String acharDadoArquivo (String palavraAntecedente) {
		while (entrada.hasNext()) {
			if(entrada.next().toLowerCase().contains(palavraAntecedente.toLowerCase()))
				return entrada.next();
		}
		return null;
	}

	// M�todo para verificar se a palavra enviada como par�metro esta contida no arquivo
	private static boolean lerPalavraCadastro(String palavra) {
		while (entrada.hasNext()) {
			if (entrada.nextLine().toLowerCase().contains(palavra.toLowerCase()))
				return true;
		}
		return false;
	}

	// M�todo para fechar o arquivo
	private static void fecharArquivo() {
		try {
			if (saida != null)
				saida.close();
		} catch (IOException e) {
			System.err.println("Erro ao fechar o arquivo");
			System.exit(1);
		}
	}

	// M�todo para verificar a exist�ncia do cadastro
	public static boolean verificarCadastroExistente(String NomeArquivo) {
		Path path = Paths.get(NomeArquivo + ".txt");
		if (Files.exists(path))
			return true;

		return false;
	}

	// M�todo para validar o cpf
	public static boolean validaCPF(String cpf) {
		if (cpf.length() != 11)
			return false;

		return true;
	}

}
