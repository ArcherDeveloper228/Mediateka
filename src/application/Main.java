package application;

import client.ClientConnection;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	/** Property - stage */
	private Stage stage;

	@Override
	public void start(Stage primaryStage) {

		primaryStage = new ClientConnection();
		this.stage = primaryStage;

	}

	public static void main(String[] args) {
		launch(args);	
	}

}