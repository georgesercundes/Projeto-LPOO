package br.com.poli.view;

import java.util.ArrayList;

import br.com.poli.sistema.Atendimento;
import br.com.poli.sistema.Cadastro;
import br.com.poli.sistema.Executar;
import br.com.poli.usuario.Aluno;
import br.com.poli.usuario.Professor;
import br.com.poli.util.DadosMudancaDeTela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ControllerTelaAgendamentoAluno {

	private Professor professorSelecionado;
	private int indiceAtendimentoSelecionado;
	private ArrayList<Professor> professoresLista = new ArrayList<>();

	@FXML
	private ComboBox<String> comboBoxProfessores;

	@FXML
	private ComboBox<String> comboBoxHorarios;

	@FXML
	private Button btnAgendar;

	@FXML
	private ComboBox<String> comboBoxAtendimentos;

	@FXML
	public void initialize() {
		carregarProfessoresNomes();
	}

	@FXML
	public void carregarAtendimentosComboBox(ActionEvent event) {
		carregarAtendimentos();
	}

	@FXML
	public void carregarHorariosAtendimentoComboBox(ActionEvent event) {
		carregarHorariosDeAtendimento();
	}

	@FXML
	void clickAgendar(ActionEvent event) {
		if (!(comboBoxProfessores.getSelectionModel().isEmpty() && comboBoxAtendimentos.getSelectionModel().isEmpty()
				&& comboBoxHorarios.getSelectionModel().isEmpty())) {
			Aluno aluno = (Aluno) Cadastro.resgatarUsuarioCadastro(DadosMudancaDeTela.getCpfUsuario());
			String diaAtendimentoSelecionado = professorSelecionado.getAtendimentos().get(indiceAtendimentoSelecionado)
					.getDiaDoAtendimento();
			String horarioAtendimentoSelecionado = comboBoxHorarios.getValue();
			Executar.efetuarAgendamento(aluno, professorSelecionado, diaAtendimentoSelecionado,
					horarioAtendimentoSelecionado);
			Alert info = new Alert(AlertType.INFORMATION);
			info.setTitle("Agendamento");
			info.setHeaderText(null);
			info.setContentText("Horário Agendado com Sucesso");
			info.showAndWait();
			try {
				new SegundaTela("TelaPrincipalAlunos.fxml").start(MainApp.stage);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@FXML
	void clickVoltar(MouseEvent event) {
		try {
			new SegundaTela("TelaPrincipalAlunos.fxml").start(MainApp.stage);
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

	public void carregarProfessoresNomes() {
		ArrayList<String> professoresListaNomes = new ArrayList<>();
		professoresLista = Cadastro.listaProfessoresCadastrados();
		if (professoresLista.size() == 0)
			comboBoxProfessores.setValue("Não há professores cadastrados");
		else {
			for (Professor professor : professoresLista)
				professoresListaNomes.add(professor.getNome());

			ObservableList<String> obsProfessoresListaNomes = FXCollections.observableArrayList(professoresListaNomes);
			comboBoxProfessores.setItems(obsProfessoresListaNomes);
		}
	}

	public void carregarAtendimentos() {
		comboBoxAtendimentos.getItems().clear();
		if (!comboBoxProfessores.getSelectionModel().isEmpty()) {
			int indiceProfessorSelecionado = comboBoxProfessores.getSelectionModel().getSelectedIndex();
			professorSelecionado = professoresLista.get(indiceProfessorSelecionado);
			ArrayList<Atendimento> atendimentosLista = new ArrayList<>();
			atendimentosLista = professorSelecionado.getAtendimentos();
			ArrayList<String> atendimentosListaDias = new ArrayList<>();
			if (atendimentosLista.size() == 0)
				comboBoxAtendimentos.setValue("Não há atendimentos disponíveis");
			else {
				comboBoxAtendimentos.setValue("Selecionar Atendimento");
				for (Atendimento atendimento : atendimentosLista)
					atendimentosListaDias.add(atendimento.getDiaDoAtendimento());

				ObservableList<String> obsAtendimentosListaDias = FXCollections
						.observableArrayList(atendimentosListaDias);
				comboBoxAtendimentos.setItems(obsAtendimentosListaDias);

			}
		} else
			comboBoxProfessores.requestFocus();

	}

	public void carregarHorariosDeAtendimento() {
		comboBoxHorarios.getItems().clear();
		if (!comboBoxAtendimentos.getSelectionModel().isEmpty()) {
			indiceAtendimentoSelecionado = comboBoxAtendimentos.getSelectionModel().getSelectedIndex();
			Atendimento atendimentoSelecionado = professorSelecionado.getAtendimentos()
					.get(indiceAtendimentoSelecionado);
			ArrayList<String> horariosLista = new ArrayList<>();
			horariosLista = atendimentoSelecionado.getHorariosDeAtendimentoDisponiveis();
			if (horariosLista.size() == 0)
				comboBoxHorarios.setValue("Não há horários disponíveis");
			else {
				comboBoxHorarios.setValue("Selecionar Horário do Agendamento");
				ObservableList<String> obsHorariosLista = FXCollections.observableArrayList(horariosLista);
				comboBoxHorarios.setItems(obsHorariosLista);
			}
		} else
			comboBoxAtendimentos.requestFocus();

	}

}
