package authorization;

import application.User;
import client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import json.UserComand;
import mediateka.Mediateka;
import registration.Registration;

/**
 * Class-controller for .fxml document "Authorization.fxml"
 * @author Nikita.Ustyshenko
 * @version 1.0
 * */
public class AuthorizationController implements ConstAuthorization {

	/** Property - client */
	private Client client;

	// выполняем пробное подключение  серверу
	{
		this.client = new Client();
		this.client.closeConnection();
	}

    @FXML
    private TextField login_field;

    @FXML
    private Button button_signIn;

    @FXML
    private PasswordField passwrod_field;

    @FXML
    private Hyperlink registration_hyperlink;

    @FXML
    private CheckBox show_password;

    @FXML
    private Label password_label;

	@FXML
    private void initialize() {

    	// устанавливаем обработчик события для гиперссылки  registrationHyperlink
    	this.registration_hyperlink.setOnAction(event -> {

    		if (this.client != null) this.client.closeConnection();
    		this.registration_hyperlink.getScene().getWindow().hide();
    		new Registration().show();

    	});

    	// устанавливаем обработчик события для кнопки button_signIn
    	this.button_signIn.setOnAction(event -> {

    		// проверяем на правильное заполнение полей
    		if (this.login_field.getText().trim().equals("") || this.passwrod_field.getText().trim().equals("")) {

    			this.showDialogMessage("Attention", "You didn't enter login(password)!");

    		} else {

    			User user = new User();
    			user.setUserLogin(this.login_field.getText().trim());
    			user.setUserPassword(this.passwrod_field.getText().trim());

    			this.client = new Client();
    			this.client.getClientInterface().writeMessage(user, TITLE_WINDOW);

    			UserComand user_command = this.client.getClientInterface().readMessage();

    			// выполняем проверку ответа сервера на авторизацию клиента
    			if (user_command.getCommand().equals("Ok")) {

    				this.client.closeConnection();
    				this.button_signIn.getScene().getWindow().hide();
    				new Mediateka(user).show();

    			} else {

    				this.client.closeConnection();
    				this.passwrod_field.setText("");
    				this.showDialogMessage("Attention", user_command.getCommand());

    			}

    		}

    	});

    	// устанавливаем обработчик события для ComboBox show_password
    	this.show_password.setOnAction(event -> {

    		if (this.show_password.isSelected()) this.password_label.setText(this.passwrod_field.getText());
    		else this.password_label.setText("");

    	});

    }

    /**
     * This method creates dialog window and prints information
     * @param title value of the window title
     * @param message value of the information message
     * */
    public final void showDialogMessage(String title, String message) {

    	Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText("");
		alert.setContentText(message);
		alert.showAndWait();

    }

    /**
     * This method get object Client
     * @return value of the object Client
     * */
    public Client getClient() {

    	return this.client;

    }

    /**
     * This method set value of the object Client
     * @param client value of the object Client
     * */
    public void setClient(Client client) {

    	this.client = client;

    }

}
