package br.com.poli.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import br.com.poli.sistema.Atendimento;
import br.com.poli.sistema.Cadastro;
import br.com.poli.sistema.Executar;
import br.com.poli.usuario.Professor;
import br.com.poli.util.DadosMudancaDeTela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ControllerTelaDefinirAtendimentoProfessor {

	private ArrayList<String> turno = new ArrayList<>();
	private Atendimento atendimento;
	private ObservableList<String> obsTurno;

	@FXML
	private DatePicker DatePickerProfessor;

	@FXML
	private Button definirButton;

	@FXML
	private ComboBox<String> comboBoxTurno;

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
	public void clickVoltar(MouseEvent event) throws Exception {
		try {
			new SegundaTela("TelaPrincipalProfessor.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void initialize() {
		DatePickerProfessor.setValue(LocalDate.now());
		carregarTurnos();
	}

	@FXML
	public void clickDefinir(ActionEvent event) {
		definirAtendimento();
	}

	public void carregarTurnos() {
		turno.add("Manh�");
		turno.add("Tarde");
		obsTurno = FXCollections.observableArrayList(turno);
		comboBoxTurno.setItems(obsTurno);
	}

	public void definirAtendimento() {

		if (!comboBoxTurno.getSelectionModel().isEmpty() && DatePickerProfessor.getValue() != null) {
			LocalDate diaAtendimento = DatePickerProfessor.getValue();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			String diaAtendimentoFormatado = diaAtendimento.format(formatter);
			String turnoAtendimento = comboBoxTurno.getValue();
			String cpfProfessor = DadosMudancaDeTela.getCpfUsuario();
			Professor professor = (Professor) Cadastro.resgatarUsuarioCadastro(cpfProfessor);
			if (Executar.jaExisteAtendimento(professor, diaAtendimentoFormatado)) {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Erro");
				alerta.setHeaderText(null);
				alerta.setContentText("J� existe um hor�rio de atendimento definido para este dia");
				alerta.showAndWait();
			} else {
				atendimento = new Atendimento(turnoAtendimento, diaAtendimentoFormatado);
				Executar.definirAtendimento(professor, atendimento);
				mostrarHorariosDeAtendimento();
			}
		}

	}

	public void mostrarHorariosDeAtendimento() {
		String mensagem1 = String.format("%s%n", "Hor�rios de Atendimento: ");
		ArrayList<String> horariosAtendimento = atendimento.getHorariosDeAtendimentoDisponiveis();
		String mensagem2 = String.format("1: %s%n", horariosAtendimento.get(0));
		for (int counter = 1; counter < horariosAtendimento.size(); counter++)
			mensagem2 = String.format("%s%s: %s%n", mensagem2, counter + 1, horariosAtendimento.get(counter));
		String mensagemFinal = mensagem1 + mensagem2;
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("Atendimento");
		info.setHeaderText("Atendimento registrado com sucesso");
		info.setContentText(mensagemFinal);
		info.showAndWait();
	}
}
