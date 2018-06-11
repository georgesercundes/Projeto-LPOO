package br.com.poli.view;

import br.com.poli.sistema.Cadastro;
import br.com.poli.usuario.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ControllerTelaCadastroProfessor {

	@FXML
    private PasswordField txtSenhaProfessor;

    @FXML
    private TextField txtCpfProfessor;

    @FXML
    private TextField txtNomeProfessor;

    @FXML
    private TextField txtCoordenacaoProfessor;
    
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
			if (Cadastro.validaCPF(txtCpfProfessor.getText())) {
				Professor professor = new Professor(txtNomeProfessor.getText(), txtCpfProfessor.getText(), txtSenhaProfessor.getText(), txtCoordenacaoProfessor.getText());
				Cadastro.cadastrarUsuario(professor, professor.getCpf());
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
				txtCpfProfessor.clear();
				txtCpfProfessor.selectAll();
				txtCpfProfessor.requestFocus();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
