package br.com.poli.view;

import java.util.ArrayList;
import java.util.Collections;

import br.com.poli.sistema.Atendimento;
import br.com.poli.sistema.Cadastro;
import br.com.poli.usuario.Professor;
import br.com.poli.util.DadosMudancaDeTela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class ControllerTelaAlunosAgendadosProfessor {

	private String cpfProfessor = DadosMudancaDeTela.getCpfUsuario();
	private Professor professor = (Professor) Cadastro.resgatarUsuarioCadastro(cpfProfessor);
	private ArrayList<Atendimento> atendimentos = new ArrayList<>();

	@FXML
	private ListView<String> listViewAgendamentos;
	@FXML
	private ComboBox<String> comboBoxAtendimento;

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

	public void initialize() {
		carregarAtendimentosComboBox();
	}

	public void clickAtendimentos(ActionEvent event) {
		carregarListViewAgendamentos();
	}

	public void carregarListViewAgendamentos() {
		listViewAgendamentos.getItems().clear();
		if (!comboBoxAtendimento.getSelectionModel().isEmpty()) {
			int indiceAtendimentoSelecionado = comboBoxAtendimento.getSelectionModel().getSelectedIndex();
			Atendimento atendimentoSelecionado = atendimentos.get(indiceAtendimentoSelecionado);
			ArrayList<String> agendamentos = new ArrayList<>();
			ArrayList<String> horariosAgendados = atendimentoSelecionado.getHorariosDeAtendimentoAgendados();
			for (int counter = 0; counter < horariosAgendados.size(); counter++) {
				String nomeAlunoAgendado = atendimentoSelecionado.getAlunosAtendimento().get(counter).getNome();
				String nomeAlunoAgendadoCPF = atendimentoSelecionado.getAlunosAtendimento().get(counter).getCpf();
				String cursoAlunoAgendado = atendimentoSelecionado.getAlunosAtendimento().get(counter).getCurso();
				String agendamento = String.format("Nome: %s - CPF: %s - Curso: %s - %s", nomeAlunoAgendado,
						nomeAlunoAgendadoCPF, cursoAlunoAgendado, horariosAgendados.get(counter));
				agendamentos.add(agendamento);
			}
			Collections.sort(agendamentos);
			ObservableList<String> obsAgendamentos = FXCollections.observableArrayList(agendamentos);
			listViewAgendamentos.setItems(obsAgendamentos);
		} else
			comboBoxAtendimento.requestFocus();
	}

	public void carregarAtendimentosComboBox() {
		ArrayList<String> atendimentosCb = new ArrayList<>();
		atendimentos = professor.getAtendimentos();
		if (atendimentos.size() == 0)
			comboBoxAtendimento.setValue("Não há nenhum dia de atendimento");
		else {
			for (Atendimento atendimento : atendimentos)
				atendimentosCb.add(atendimento.getDiaDoAtendimento());

			ObservableList<String> obsAtendimentosCb = FXCollections.observableArrayList(atendimentosCb);
			comboBoxAtendimento.setItems(obsAtendimentosCb);

		}

	}
}
