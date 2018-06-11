package br.com.poli.view;

import java.util.ArrayList;

import br.com.poli.sistema.Login;
import br.com.poli.util.DadosMudançaDeTela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControllerTelaLogin {

	private ArrayList<String> tiposUsuarios = new ArrayList<>();

	private ObservableList<String> obsTiposUsuarios;

	@FXML
	private TextField txtLogin;

	@FXML
	private PasswordField txtSenha;

	@FXML
	private Button btnEntrar;

	@FXML
	private Button btnCriarConta;

	@FXML
	private Button btnLogin;

	@FXML
	private ComboBox<String> cbTipoLogin;

	@FXML
	public void initialize() {
		carregarTiposUsuarios();
	}

	@FXML
	public void CriarConta(ActionEvent event) {
		try {
			new SegundaTela("TelaSelecaoDeCadastro.fxml").start(MainApp.stage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void Entrar(ActionEvent event) {
		String TipoUsuarioSelecionado = cbTipoLogin.getSelectionModel().getSelectedItem();
		Login login = new Login(txtLogin.getText(), txtSenha.getText());

		if (TipoUsuarioSelecionado == null) {
			cbTipoLogin.requestFocus();
		}

		else {
			if (login.validaCPF(txtLogin.getText())) {
				if (login.logar()) {
					DadosMudançaDeTela.setCpfUsuario(txtLogin.getText());
					if (TipoUsuarioSelecionado.equals(tiposUsuarios.get(0))) {
						try {
							new SegundaTela("TelaPrincipalAluno.fxml").start(MainApp.stage);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					else if (TipoUsuarioSelecionado.equals(tiposUsuarios.get(1))) {
						try {
							new SegundaTela("TelaPrincipalFuncionario.fxml").start(MainApp.stage);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					else if (TipoUsuarioSelecionado.equals(tiposUsuarios.get(2))) {
						try {
							new SegundaTela("TelaPrincipalProfessor.fxml").start(MainApp.stage);
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

				}

				else {

					Alert alerta = new Alert(AlertType.ERROR);
					alerta.setTitle("Erro");
					alerta.setHeaderText(null);
					alerta.setContentText("Usuário não cadastrado ou senha inválida");
					alerta.showAndWait();
				}

			}

			else {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Erro");
				alerta.setHeaderText(null);
				alerta.setContentText("Você digitou um CPF inválido, tente novamente");
				alerta.showAndWait();
				txtLogin.clear();
				txtLogin.selectAll();
				txtLogin.requestFocus();
			}

		}

	}

	public void carregarTiposUsuarios() {
		tiposUsuarios.add("Aluno");
		tiposUsuarios.add("Funcionário");
		tiposUsuarios.add("Professor");
		obsTiposUsuarios = FXCollections.observableArrayList(tiposUsuarios);
		cbTipoLogin.setItems(obsTiposUsuarios);
	}

}


