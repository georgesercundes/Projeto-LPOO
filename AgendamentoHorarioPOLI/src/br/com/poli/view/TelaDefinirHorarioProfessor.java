package br.com.poli.view;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class TelaDefinirHorarioProfessor {

	private ArrayList<String> turno = new ArrayList<>();

	private ObservableList<String> obsTurno;
	
	@FXML
	private DatePicker DatePickerProfessor;

	@FXML
	private Button definirButton;

	@FXML
	private ComboBox <String> comboBoxTurno;

	@FXML
	public void clickCadastrar(ActionEvent event) {

	}
	
	@FXML
	public void initialize() {
		DatePickerProfessor.setValue(LocalDate.now());
		carregarTurnos();
	}
	
	public void carregarTurnos() {
		turno.add("Manhã");
		turno.add("Tarde");
		obsTurno = FXCollections.observableArrayList(turno);
		comboBoxTurno.setItems(obsTurno);
	}

}
