package br.com.poli.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ControllerTelaPrincipalAluno {

	@FXML
	private Button btnRealizarAgendamento;

	@FXML
	private Button btnGerenciarAgendamentoAluno;

	@FXML
	void clickSairDaConta(MouseEvent event) {

		try {
			new SegundaTela("TelaLogin.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void clickRealizarAgendamento(ActionEvent event) throws Exception {
		try {
			new SegundaTela("TelaAgendamentoAluno.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickGerenciarAgendamentos(ActionEvent event) throws Exception {
		try {
			new SegundaTela("TelaGerenciarAgendamentosAluno.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
