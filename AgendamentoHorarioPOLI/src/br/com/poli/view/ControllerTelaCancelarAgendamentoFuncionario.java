package br.com.poli.view;

import java.util.ArrayList;
import java.util.Collections;
import br.com.poli.sistema.Agendamento;
import br.com.poli.sistema.Cadastro;
import br.com.poli.sistema.Executar;
import br.com.poli.usuario.Aluno;
import br.com.poli.usuario.ComunidadeAcademicaPoli;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ControllerTelaCancelarAgendamentoFuncionario {

	@FXML
	private TextField alunoCpfTextField;

	@FXML
	private Button btnRemoverAgendamento;

	@FXML
	private ListView<String> listViewAgendamentos;

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
			new SegundaTela("TelaPrincipalFuncionario.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void carregarListViewAgendamentos(ActionEvent event) {
		carregarListViewAgendamentos();
	}

	@FXML
	void clickRemoverAgendamento(ActionEvent event) {
		if (!listViewAgendamentos.getSelectionModel().isEmpty()) {
			int indiceAgendamentoSelecionado = listViewAgendamentos.getSelectionModel().getSelectedIndex();
			String cpfAluno = alunoCpfTextField.getText();
			ComunidadeAcademicaPoli alunoChecagem = Cadastro.resgatarUsuarioCadastro(cpfAluno);
			if (alunoChecagem instanceof Aluno) {
				Aluno aluno = (Aluno) alunoChecagem;
				Executar.removerAgendamento(aluno, indiceAgendamentoSelecionado);
				Alert info = new Alert(AlertType.INFORMATION);
				info.setTitle("Agendamento");
				info.setHeaderText(null);
				info.setContentText("Agendamento removido com sucesso");
				info.showAndWait();
				try {
					new SegundaTela("TelaPrincipalFuncionario.fxml").start(MainApp.stage);
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}

			else {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Erro");
				alerta.setHeaderText(null);
				alerta.setContentText("Você digitou um CPF de outro tipo de Usuário, tente novamente");
				alerta.showAndWait();
				alunoCpfTextField.requestFocus();
			}

		}

		else {
			listViewAgendamentos.requestFocus();
		}

	}

	public void carregarListViewAgendamentos() {
		String cpfAluno = alunoCpfTextField.getText();
		if (Cadastro.verificarSeCadastroExiste(cpfAluno)) {
			ComunidadeAcademicaPoli alunoChecagem = Cadastro.resgatarUsuarioCadastro(cpfAluno);
			if(alunoChecagem instanceof Aluno) {
				Aluno aluno  = (Aluno) alunoChecagem;
				ArrayList<Agendamento> agendamentos = aluno.getAgendamentos();
				ArrayList<String> agendamentosListView = new ArrayList<>();
				for (Agendamento agendamento : agendamentos) {
					String diaAgendado = agendamento.getDiaDoAtendimento();
					String nomeProfessorAgendado = agendamento.getProfessorAgendado().getNome();
					String horarioAgendado = agendamento.getHorarioDoAtendimento();
					String agendamentoFormatado = String.format("Dia: %s - Professor: %s - Horario:  %s", diaAgendado,
							nomeProfessorAgendado, horarioAgendado);
					agendamentosListView.add(agendamentoFormatado);
				}
				Collections.sort(agendamentosListView);
				ObservableList<String> obsAgendamentosListView = FXCollections.observableArrayList(agendamentosListView);
				listViewAgendamentos.setItems(obsAgendamentosListView);
			}
			
			else {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Erro");
				alerta.setHeaderText(null);
				alerta.setContentText("Você digitou um CPF de outro tipo de Usuário, tente novamente");
				alerta.showAndWait();
				alunoCpfTextField.requestFocus();
			}
			
		} 
		
		else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Erro");
			alerta.setHeaderText(null);
			alerta.setContentText("Você digitou um CPF inválido, tente novamente");
			alerta.showAndWait();
		}

	}

}
