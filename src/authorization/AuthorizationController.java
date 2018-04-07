package authorization;

import application.User;
import database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mediateka.Mediateka;
import registration.Registration;

/**
 * Class-controller for .fxml document "Authorization.fxml"
 * @author Nikita.Ustyshenko
 * @version 1.0
 * */
public class AuthorizationController {
	
	/** Property - database */
	private Database database;
	
	{ this.database = new Database(); }
	
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

    		this.registration_hyperlink.getScene().getWindow().hide();
    		new Registration().show();

    	});

    	// устанавливаем обработчик события для кнопки button_signIn
    	this.button_signIn.setOnAction(event -> {

    		User user = null;
    		
    		// выполняем поиск пользователя по логину
    		for (User check_user : this.database.getTable()) {
    			
    			if (check_user.getUserLogin().equals(this.login_field.getText().trim())) user = check_user;
    			
    		}
    		
    		// проверяем на правильное заполнение полей 
    		if (this.login_field.getText().trim().equals("") || this.passwrod_field.getText().trim().equals("")) {
    			
    			this.showDialogMessage("Attention", "You didn't enter login(password)!");
    			
    		} else if (user == null || user.getUserPassword() != this.passwrod_field.getText().hashCode()) {
    			
    			this.passwrod_field.setText("");
    			this.showDialogMessage("Attention", "Check your login or password!");
    			
    		} else {
    			
    			this.button_signIn.getScene().getWindow().hide();
        		new Mediateka().show();
        	
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

}
