package br.com.poli.sistema;

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
		if (Cadastro.verificarCadastroExistente(getLogin())) {
			if (Cadastro.verificarSeEstaContido(getLogin(), getSenha()))
				return true;
		}

		return false;
	}

	// M�todo para validar o cpf
	public boolean validaCPF(String cpf) {
		if (cpf.length() != 11)
			return false;

		return true;
	}

}
