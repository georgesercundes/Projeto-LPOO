package br.com.poli.view;

import java.util.ArrayList;
import java.util.Collections;

import br.com.poli.sistema.Agendamento;
import br.com.poli.sistema.Cadastro;
import br.com.poli.sistema.Executar;
import br.com.poli.usuario.Aluno;
import br.com.poli.util.DadosMudancaDeTela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ControllerTelaGerenciarAgendamentosAluno {

	@FXML
	private Button btnRemoverAgendamento;

	@FXML
	private ListView<String> listViewAgendamentos;
	
	private String cpfAluno = DadosMudancaDeTela.getCpfUsuario();
	private Aluno aluno = (Aluno) Cadastro.resgatarUsuarioCadastro(cpfAluno);

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
			new SegundaTela("TelaPrincipalAlunos.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void initialize() {
		carregarListViewAgendamentos();
	}

	@FXML
	void clickRemoverAgendamento(ActionEvent event) {
		if(!listViewAgendamentos.getSelectionModel().isEmpty()) {
			int indiceAgendamentoSelecionado = listViewAgendamentos.getSelectionModel().getSelectedIndex();
			Executar.removerAgendamento(aluno, indiceAgendamentoSelecionado);
			Alert info = new Alert(AlertType.INFORMATION);
			info.setTitle("Agendamento");
			info.setHeaderText(null);
			info.setContentText("Agendamento removido com sucesso");
			info.showAndWait();
			try {
				new SegundaTela("TelaPrincipalAlunos.fxml").start(MainApp.stage);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			listViewAgendamentos.requestFocus();
		}
		

	}
	
	public void carregarListViewAgendamentos() {
		ArrayList<Agendamento> agendamentos = aluno.getAgendamentos();
		ArrayList<String> agendamentosListView = new ArrayList<>();
		for(Agendamento agendamento: agendamentos) {
			String diaAgendado = agendamento.getDiaDoAtendimento();
			String nomeProfessorAgendado = agendamento.getProfessorAgendado().getNome();
			String horarioAgendado = agendamento.getHorarioDoAtendimento();
			String agendamentoFormatado = String.format("Dia: %s - Professor: %s - Horario:  %s", diaAgendado, nomeProfessorAgendado, horarioAgendado);
			agendamentosListView.add(agendamentoFormatado);
		}
		Collections.sort(agendamentosListView);
		ObservableList<String> obsAgendamentosListView = FXCollections.observableArrayList(agendamentosListView);
		listViewAgendamentos.setItems(obsAgendamentosListView);
	}

}
