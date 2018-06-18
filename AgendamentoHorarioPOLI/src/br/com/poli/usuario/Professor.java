package br.com.poli.usuario;

import java.util.ArrayList;
import br.com.poli.sistema.Atendimento;

public class Professor extends ComunidadeAcademicaPoli {

	// Atributos da classe
	private static final long serialVersionUID = 1L;
	private String cursoCoordenacao;
	private ArrayList<Atendimento> atendimentos = new ArrayList<>();

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

	public void setAtendimentos(Atendimento atendimento) {
		atendimentos.add(atendimento);
	}

	public ArrayList<Atendimento> getAtendimentos() {
		return atendimentos;
	}

}
