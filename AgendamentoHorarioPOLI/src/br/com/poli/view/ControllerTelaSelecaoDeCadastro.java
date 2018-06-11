package br.com.poli.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ControllerTelaSelecaoDeCadastro {

	@FXML
	private Button btnCadastroAluno;

	@FXML
	private Button btnCadastroProfessor;

	@FXML
	private Button btnCadastroFuncionario;

	@FXML
	public void clickVoltar(MouseEvent event) throws Exception {
		try {
			new SegundaTela("TelaLogin.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickCadastroAluno(ActionEvent event) throws Exception {
		try {
			new SegundaTela("TelaCadastroAluno.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickCadastroFuncionario(ActionEvent event) throws Exception {
		try {
			new SegundaTela("TelaCadastroFuncionario.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickCadastroProfessor(ActionEvent event) throws Exception {
		try {
			new SegundaTela("TelaCadastroProfessor.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
