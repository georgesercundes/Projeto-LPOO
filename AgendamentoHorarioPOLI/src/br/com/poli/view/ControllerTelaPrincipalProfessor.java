package br.com.poli.view;

import br.com.poli.util.DadosMudançaDeTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerTelaPrincipalProfessor {

    @FXML
    private Button btnMarcarHorarioAtendimento;
    
    @FXML
    private TextField txtProfessorPrincipal;

    @FXML
    private Button btnAcompanharAtendimento;
    

    @FXML
    public void initialize() {
    	txtProfessorPrincipal.setText(DadosMudançaDeTela.getCpfUsuario());
    }

}
