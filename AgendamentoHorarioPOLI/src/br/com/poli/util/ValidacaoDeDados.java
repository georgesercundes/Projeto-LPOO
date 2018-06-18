package br.com.poli.util;

import br.com.poli.sistema.Cadastro;

public class ValidacaoDeDados {

	// Método para validar o cpf
	public static boolean validarCPF(String cpf) {
		if (cpf.length() != 11)
			return false;

		return true;
	}

	public static boolean validarSenha(String cpf, String senha) {
		if (Cadastro.resgatarUsuarioCadastro(cpf).getSenha().equals(senha))
			return true;

		return false;

	}

}
