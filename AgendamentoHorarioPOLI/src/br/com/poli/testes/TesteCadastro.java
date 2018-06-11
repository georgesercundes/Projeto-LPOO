package br.com.poli.testes;

import java.io.IOException;

import br.com.poli.sistema.Cadastro;
import br.com.poli.sistema.Login;
import br.com.poli.usuario.*;

public class TesteCadastro {
	
	public static void main (String [] args) throws ClassNotFoundException, IOException {
		
	
	Aluno aluno1 = new Aluno("George", "07396169437","12345", "Computação", "LF");
	Aluno aluno2 = new Aluno("Pedro", "12345678985", "12345","Civil", "MP");
	Aluno aluno3 = new Aluno("Abner", "12345678985","12345", "Elétrica", "MP");
	
	Professor prof1 = new Professor ("Ivan", "12345878923","12345", "Básico");
	Professor prof2 = new Professor ("Bruno", "12345878956","12345", "Computação");
	Professor prof3 = new Professor ("Igor", "12345878978","12345", "Elétrica");

	Funcionario func1 = new Funcionario ("João", "12345678956","12345", "office boy");
	Funcionario func2 = new Funcionario ("Paulo", "12345678956","12345","Aux. Adm");
	
	
	Cadastro.cadastrarUsuario(prof1, prof1.getCpf());
	System.out.println(Cadastro.verificarSeEstaContido(prof1.getCpf(), prof1.getSenha()));

	System.out.println(Cadastro.verificarSeEstaContido(prof1.getCpf(), "teucu"));
	
	Login login = new Login(prof1.getCpf(), prof1.getSenha());
	Login login2 = new Login(prof1.getCpf(),"teucu");
	
	System.out.println(login.logar());
	System.out.println(login2.logar());

	}	
	
}
