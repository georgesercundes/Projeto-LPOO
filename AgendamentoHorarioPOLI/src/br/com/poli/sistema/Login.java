package br.com.poli.sistema;

import br.com.poli.util.ValidacaoDeDados;

public class Login {

	private String login;
	private String senha;

	public Login(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean logar() {
		if (Cadastro.verificarSeCadastroExiste(getLogin())) {
			if (ValidacaoDeDados.validarSenha(getLogin(), getSenha()))
				return true;
		}

		return false;
	}

}
