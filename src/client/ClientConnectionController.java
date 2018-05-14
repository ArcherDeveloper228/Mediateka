package client;

import authorization.Authorization;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Class-controller for .fxml document "ClientConnection"
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class ClientConnectionController {

	@FXML
	private Button button_connection;
	
	@FXML
	private TextField id_text_field;
	
	@FXML 
	private TextField port_text_field;
	
	@FXML
	private void initialize() {
		
		// устанавливаем обработчик события для кнопки button_connection
		this.button_connection.setOnAction(event -> {
			
			if (!this.port_text_field.getText().trim().equals("") && !this.id_text_field.getText().trim().equals("")) {
				
				
				Client.setPort(Integer.parseInt(this.port_text_field.getText().trim())); 
				Client.setIpAddress(this.id_text_field.getText().trim());
				this.button_connection.getScene().getWindow().hide();
				new Authorization().show();
				
			} else {
				
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Attention");
				alert.setHeaderText("");
				alert.setContentText("Please, input all information!");
				alert.showAndWait();
				
			}
			
		});
		
	}
	
}
