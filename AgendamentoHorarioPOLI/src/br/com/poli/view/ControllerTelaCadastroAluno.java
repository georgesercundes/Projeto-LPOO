package br.com.poli.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import br.com.poli.usuario.Aluno;
import br.com.poli.sistema.Cadastro;

public class ControllerTelaCadastroAluno {

	@FXML
	private TextField txtcpfAluno;

	@FXML
	private TextField txtCursoAluno;

	@FXML
	private Button btnCadastrar;

	@FXML
	private TextField txtTurmaAluno;

	@FXML
	private PasswordField txtSenhaAluno;

	@FXML
	private TextField txtNomeAluno;

	@FXML
	public void clickVoltar(MouseEvent event) throws Exception {
		try {
			new SegundaTela("TelaSelecaodeCadastro.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickCadastrar(ActionEvent event) throws Exception {
		try {
			if (Cadastro.validaCPF(txtcpfAluno.getText())) {
				Aluno aluno = new Aluno(txtNomeAluno.getText(), txtcpfAluno.getText(), txtSenhaAluno.getText(),
						txtCursoAluno.getText(), txtTurmaAluno.getText());
				Cadastro.cadastrarUsuario(aluno, aluno.getCpf());
				Alert info = new Alert(AlertType.INFORMATION);
				info.setTitle("Usuário Cadastrado");
				info.setHeaderText(null);
				info.setContentText("Cadastro Realizado com Sucesso");
				info.showAndWait();
				try {
					new SegundaTela("TelaLogin.fxml").start(MainApp.stage);
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}

			else {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Erro");
				alerta.setHeaderText(null);
				alerta.setContentText("Você digitou um CPF inválido, tente novamente");
				alerta.showAndWait();
				txtcpfAluno.clear();
				txtcpfAluno.selectAll();
				txtcpfAluno.requestFocus();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
