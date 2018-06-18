package br.com.poli.sistema;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import br.com.poli.usuario.Aluno;
import br.com.poli.usuario.ComunidadeAcademicaPoli;
import br.com.poli.usuario.Funcionario;
import br.com.poli.usuario.Professor;

/* 
 * Classe de cadastro para armazenar os dados permanentemente no disco rígido 
 * 
 * Os dados serão armazenados no cpf dos usuarios visando facilitar a recuperação das informações
 * 
 * */
public class Cadastro {

	private static ObjectOutputStream saida;
	private static ObjectInputStream entrada;
	private static ComunidadeAcademicaPoli usuarioCadastrado;
	private static String userDir = System.getProperty("user.dir");
	private static File diretorioProfessores = new File(userDir + "\\Cadastro\\Professores\\");
	private static File diretorioAlunos = new File(userDir + "\\Cadastro\\Alunos\\");
	private static File diretorioFuncionarios = new File(userDir + "\\Cadastro\\Funcionarios\\");

	// Método para cadastrar/atualizar os usuários
	public static void cadastrar(ComunidadeAcademicaPoli usuarioCadastro, String cpf) {
		abrirArquivoCadastro(usuarioCadastro, cpf);
		gravarDados(usuarioCadastro);
		fecharArquivo();

	}

	// Método para remover o cadastro
	public static void removerCadastro(String cpf) {
		try {
			Files.deleteIfExists(acharDiretorio(cpf));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método para desserializar os objetos arquivados
	public static ComunidadeAcademicaPoli resgatarUsuarioCadastro(String cpf) {
		abrirArquivoLeitura(cpf);
		ComunidadeAcademicaPoli usuario = lerDados();
		fecharArquivo();
		return usuario;
	}

	// Método para verificar a existencia de um cadastro
	public static boolean verificarSeCadastroExiste(String cpf) {
		Path path1 = Paths.get(diretorioProfessores + "\\" + cpf);
		Path path2 = Paths.get(diretorioAlunos + "\\" + cpf);
		Path path3 = Paths.get(diretorioFuncionarios + "\\" + cpf);
		if (Files.exists(path1))
			return true;
		else if (Files.exists(path2))
			return true;
		else if (Files.exists(path3))
			return true;
		else
			return false;
	}

	// Método para recuperar todos os professores cadastrados e salva-los num arraylist
	public static ArrayList<Professor> listaProfessoresCadastrados() {
		ArrayList<Professor> listaProfessores = new ArrayList<>();
		File[] arquivosProfessores = diretorioProfessores.listFiles();
		for (File arquivo : arquivosProfessores) {
			Professor professor = (Professor) resgatarUsuarioCadastro(arquivo.getName());
			listaProfessores.add(professor);
		}
		return listaProfessores;
	}

	// Métodos abaixo realizam operações relacionadas ao cadastro
	private static Path acharDiretorio(String cpf) {
		Path path1 = Paths.get(diretorioProfessores + "\\" + cpf);
		Path path2 = Paths.get(diretorioAlunos + "\\" + cpf);
		Path path3 = Paths.get(diretorioFuncionarios + "\\" + cpf);
		if (Files.exists(path1))
			return path1;
		else if (Files.exists(path2))
			return path2;
		else
			return path3;

	}

	private static void abrirArquivoLeitura(String cpf) {
		try {
			entrada = new ObjectInputStream(Files.newInputStream(acharDiretorio(cpf)));
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo para leitura");
			System.exit(1);
		}
	}

	private static ComunidadeAcademicaPoli lerDados() {
		try {
			usuarioCadastrado = (ComunidadeAcademicaPoli) entrada.readObject();
		} catch (ClassNotFoundException e) {
			System.err.println("Tipo de Objeto inválido");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo para desserializar o objeto");
			e.printStackTrace();
			System.exit(1);
		}
		return usuarioCadastrado;
	}

	private static void abrirArquivoCadastro(ComunidadeAcademicaPoli usuarioCadastro, String cpf) {
		try {
			if (usuarioCadastro instanceof Professor) {
				if (diretorioProfessores.exists()) {
					saida = new ObjectOutputStream(Files.newOutputStream(Paths.get(diretorioProfessores + "\\" + cpf)));
					saida.reset();
					saida.flush();
				} else {
					diretorioProfessores.mkdirs();
					saida = new ObjectOutputStream(Files.newOutputStream(Paths.get(diretorioProfessores + "\\" + cpf)));
				}
			}

			if (usuarioCadastro instanceof Aluno) {
				if (diretorioAlunos.exists())
					saida = new ObjectOutputStream(Files.newOutputStream(Paths.get(diretorioAlunos + "\\" + cpf)));
				else {
					diretorioAlunos.mkdirs();
					saida = new ObjectOutputStream(Files.newOutputStream(Paths.get(diretorioAlunos + "\\" + cpf)));
				}

			}
			if (usuarioCadastro instanceof Funcionario)
				if (diretorioFuncionarios.exists())
					saida = new ObjectOutputStream(
							Files.newOutputStream(Paths.get(diretorioFuncionarios + "\\" + cpf)));
				else {
					diretorioFuncionarios.mkdirs();
					saida = new ObjectOutputStream(
							Files.newOutputStream(Paths.get(diretorioFuncionarios + "\\" + cpf)));
				}

		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo para Cadastro");
			System.exit(1);
		}

	}

	private static void gravarDados(ComunidadeAcademicaPoli usuarioCadastro) {
		try {
			saida.writeObject(usuarioCadastro);
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo");
			System.exit(1);
		}
	}

	private static void fecharArquivo() {
		try {
			if (saida != null)
				saida.close();

			else if (entrada != null)
				entrada.close();

		} catch (IOException e) {
			System.err.println("Erro ao fechar o arquivo");
			System.exit(1);
		}
	}

}
