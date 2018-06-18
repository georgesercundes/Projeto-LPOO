package br.com.poli.testes;

import br.com.poli.sistema.Cadastro;
import br.com.poli.usuario.Professor;

public class TesteGetName {

	public static void main(String[] args) {
		Professor prof = (Professor) Cadastro.resgatarUsuarioCadastro("12345678923");
		
		System.out.println(prof.getSenha());

	}

}
