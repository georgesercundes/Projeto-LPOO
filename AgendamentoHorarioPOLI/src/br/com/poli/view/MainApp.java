package br.com.poli.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Parent cena = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));

		MainApp.stage = primaryStage;
		Scene scene = new Scene(cena);
		stage.setScene(scene);
		stage.setTitle("Agendamento");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
