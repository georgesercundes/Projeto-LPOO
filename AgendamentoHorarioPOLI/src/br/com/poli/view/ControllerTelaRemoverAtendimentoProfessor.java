package br.com.poli.view;

import java.util.ArrayList;

import br.com.poli.sistema.Atendimento;
import br.com.poli.sistema.Cadastro;
import br.com.poli.sistema.Executar;
import br.com.poli.usuario.Professor;
import br.com.poli.util.DadosMudancaDeTela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ControllerTelaRemoverAtendimentoProfessor {
	
	@FXML
	private Button removerButton;

	@FXML
	private ComboBox<String> comboBoxAtendimento;

	@FXML
	void clickVoltar(MouseEvent event) {
		try {
			new SegundaTela("TelaPrincipalProfessor.fxml").start(MainApp.stage);
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
	
	@FXML
	public void initialize () {
		carregarAtendimentosComboBox();
	}

	@FXML
	public void clickRemoverButton() {
		if(!comboBoxAtendimento.getSelectionModel().isEmpty()) {
			String cpfProfessor = DadosMudancaDeTela.getCpfUsuario();
			Professor professor = (Professor) Cadastro.resgatarUsuarioCadastro(cpfProfessor);
			Executar.removerAtendimento(professor, comboBoxAtendimento.getSelectionModel().getSelectedIndex());
			comboBoxAtendimento.getSelectionModel().clearSelection();
			Alert info = new Alert(AlertType.INFORMATION);
			info.setTitle("Atendimento");
			info.setHeaderText("Atendimento removido com sucesso");
			info.setContentText(null);
			info.showAndWait();
			try {
				new SegundaTela("TelaPrincipalProfessor.fxml").start(MainApp.stage);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
			comboBoxAtendimento.requestFocus();
		
	}

	public void carregarAtendimentosComboBox() {
		String cpfProfessor = DadosMudancaDeTela.getCpfUsuario();
		Professor professor = (Professor) Cadastro.resgatarUsuarioCadastro(cpfProfessor);
		ArrayList<String> atendimentosCb = new ArrayList<>();
		ArrayList<Atendimento> atendimentos = professor.getAtendimentos();
		if(atendimentos.size() == 0)
			comboBoxAtendimento.setValue("Não há atendimento cadastrado");
		else {
			for (Atendimento atendimento : atendimentos) {
				String atendimentoFormatado = String.format("%s: %s", atendimento.getDiaDoAtendimento(),
						atendimento.getTurnoDeAtendimento());
				atendimentosCb.add(atendimentoFormatado);
			}
			ObservableList<String> obsAtendimentosCb = FXCollections.observableArrayList(atendimentosCb);
			comboBoxAtendimento.setItems(obsAtendimentosCb);
			
		}
		
	}
}
