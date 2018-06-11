package br.com.poli.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SegundaTela extends Application {

	public String link;
	public static Stage stage;

	public SegundaTela(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public static void main(String[] args) {
		Application.launch(MainApp.class);
	}

	@Override
	public void start(Stage secondaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource(getLink()));

		Scene scene = new Scene(root);

		SegundaTela.stage = secondaryStage;
		stage.setScene(scene);
		stage.setTitle("Agendamento");
		stage.show();
	}

}
