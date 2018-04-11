package application;

import java.net.ConnectException;

import authorization.Authorization;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {
	
	/** Property - stage */
	private Stage stage;
	
	@Override 
	public void start(Stage primaryStage) {
		
		primaryStage = new Authorization();
		this.stage = primaryStage;
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}