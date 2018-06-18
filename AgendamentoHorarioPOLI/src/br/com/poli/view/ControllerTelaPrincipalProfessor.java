package br.com.poli.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ControllerTelaPrincipalProfessor {

	@FXML
	private Button btnRemoverHorarioAtendimento;

	@FXML
	private Button btnAcompanharAtendimento;

	@FXML
	private Button btnMarcarHorarioAtendimento1;

	@FXML
	public void clickSairDaConta(MouseEvent event) throws Exception {
		try {
			new SegundaTela("TelaLogin.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickDefinirAtendimento(ActionEvent event) throws Exception {
		try {
			new SegundaTela("TelaDefinirAtendimentoProfessor.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickRemoverAtendimento(ActionEvent event) throws Exception {
		try {
			new SegundaTela("TelaRemoverAtendimentoProfessor.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickAgendamentos(ActionEvent event) throws Exception {
		try {
			new SegundaTela("TelaAlunosAgendadosProfessor.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
