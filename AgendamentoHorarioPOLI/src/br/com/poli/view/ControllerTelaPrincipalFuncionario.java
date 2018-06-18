package br.com.poli.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ControllerTelaPrincipalFuncionario {

	@FXML
	private Button btnRemoverHorarioAtendimento;

	@FXML
	private Button btnRealizarAgendamento1;

	@FXML
	private Button btnRealizarAgendamentoFuncionario;

	@FXML
	private Button btnMarcarHorarioAtendimento1;

	@FXML
	void clickRealizarAgendamento(ActionEvent event) {
		try {
			new SegundaTela("TelaAgendamentoFuncionario.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void clickCancelarAgendamento(ActionEvent event) {
		try {
			new SegundaTela("TelaCancelarAgendamentoFuncionario.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void clickDefinirAtendimento(ActionEvent event) {
		try {
			new SegundaTela("TelaDefinirAtendimentoFuncionario.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void clickRemoverAtendimento(ActionEvent event) {
		try {
			new SegundaTela("TelaRemoverAtendimentoFuncionario.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	void clickSairDaConta(MouseEvent event) {

		try {
			new SegundaTela("TelaLogin.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
