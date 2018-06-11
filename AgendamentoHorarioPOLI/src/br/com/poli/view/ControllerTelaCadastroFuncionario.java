package br.com.poli.view;

import br.com.poli.sistema.Cadastro;
import br.com.poli.usuario.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ControllerTelaCadastroFuncionario {

	@FXML
    private Button btnCadastrarFuncionario;

    @FXML
    private TextField txtNomeFuncionario;

    @FXML
    private TextField txtCargoFuncionario;

    @FXML
    private TextField txtCpfFuncionario;

    @FXML
    private PasswordField txtSenhaFuncionario;
    
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
			if (Cadastro.validaCPF(txtCpfFuncionario.getText())) {
				Funcionario funcionario = new Funcionario(txtNomeFuncionario.getText(), txtCpfFuncionario.getText(), txtSenhaFuncionario.getText(), txtCargoFuncionario.getText());
				Cadastro.cadastrarUsuario(funcionario, funcionario.getCpf());
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
				txtCpfFuncionario.clear();
				txtCpfFuncionario.selectAll();
				txtCpfFuncionario.requestFocus();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
