package registration;

import application.User;
import authorization.Authorization;
import client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/** Class-controller for .fxml document "Registration.fxml"
 * @author Nikita.Ustyshenko
 * @version 1.0
 * */
public class RegistrationController implements ConstRegistration {

	/** Property - client */
	private Client client;

	private final String[] NAMES_MONTHS;

	{

		this.NAMES_MONTHS = new String[] {"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"};
		this.client = new Client();

	}

	@FXML
	private TextField name_field;

	@FXML
	private TextField surname_field;

	@FXML
	private TextField login_field;

	@FXML
	private PasswordField confirm_password;

	@FXML
	private PasswordField password_field;

	@FXML
	private Button button_registration;

	@FXML
	private Button button_cancel;

	@FXML
	private RadioButton radio_man;

	@FXML
	private RadioButton radio_woman;

	@FXML
	private ComboBox<Integer> day_box;

	@FXML
	private ComboBox<String> month_box;

	@FXML
	private ComboBox<Integer> year_box;

	@FXML
	private void initialize() {

		// добавляем значения в ComboBox year_box
		for (int i = 2018; i >= 1990; i--) this.year_box.getItems().add(i);

		// добавляем значения в ComboBox month_box
		this.month_box.getItems().addAll(this.NAMES_MONTHS);

		// устанавливаем обработчик события для ComboBox month_box
		this.month_box.setOnAction(event -> {

			String month = this.month_box.getValue();

			switch (month) {

			case "January":  	for (int i = 1; i <= 31; i++) this.day_box.getItems().add(i); break;
			case "February": 	for (int i = 1; i <= 28; i++) this.day_box.getItems().add(i); break;
			case "March": 		for (int i = 1; i <= 31; i++) this.day_box.getItems().add(i); break;
			case "April": 		for (int i = 1; i <= 30; i++) this.day_box.getItems().add(i); break;
			case "May": 		for (int i = 1; i <= 31; i++) this.day_box.getItems().add(i); break;
			case "June":		for (int i = 1; i <= 30; i++) this.day_box.getItems().add(i); break;
			case "July":		for (int i = 1; i <= 31; i++) this.day_box.getItems().add(i); break;
			case "August":		for (int i = 1; i <= 31; i++) this.day_box.getItems().add(i); break;
			case "September":	for (int i = 1; i <= 30; i++) this.day_box.getItems().add(i); break;
			case "October":		for (int i = 1; i <= 31; i++) this.day_box.getItems().add(i); break;
			case "November":	for (int i = 1; i <= 30; i++) this.day_box.getItems().add(i); break;
			case "December":	for (int i = 1; i <= 31; i++) this.day_box.getItems().add(i); break;

			}

		});

		// создаем ToggleGroup для наших радио-баттонов
		ToggleGroup group = new ToggleGroup();
		this.radio_man.setToggleGroup(group);
		this.radio_woman.setToggleGroup(group);

		// устанавливаем обработчик события для кнопки button_cancel
		this.button_cancel.setOnAction(event -> {

			this.button_cancel.getScene().getWindow().hide();
			new Authorization().show();

		});

		// устанавливаем обработчик события для кнопки button_registration
		this.button_registration.setOnAction(event -> {

			// выполняем проверку на заполнение информационных графических элементов
			if (this.name_field.getText().trim().equals("") || this.surname_field.getText().trim().equals("") ||
					this.login_field.getText().trim().equals("") || this.password_field.getText().trim().equals("") ||
						this.confirm_password.getText().trim().equals("") || (!this.radio_man.isSelected() &&
							!this.radio_woman.isSelected())) this.showDialogMessage("Attention", "Please, input all information!");
			else if (!this.password_field.getText().trim().equals(this.confirm_password.getText().trim())) {

				this.confirm_password.setText("");
				this.showDialogMessage("Attention", "Please, check your password!");

			} else {

				if (this.client.getClientInterface().writeMessage(this.makeUser(), TITLE_WINDOW))
					this.button_registration.getScene().getWindow().hide();
				else {

					this.showDialogMessage("Attention", "Хз, что произошло=)");

				}

			}

		});

	}

	/**
	 * This method show dialog window
	 * @param title value of the title this window
	 * @param message value of the message that need to print
	 * */
	private final void showDialogMessage(String title, String message) {

		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText("");
		alert.setContentText(message);
		alert.showAndWait();

	}

	/**
	 * This method make user
	 * @param user it is object contains information about user
	 * */
	private final User makeUser() {

		User user = new User();

		user.setName(this.name_field.getText());
		user.setSurname(this.surname_field.getText());
		user.setDayOfBirth(this.day_box.getValue());
		user.setMonthOfBirth(this.month_box.getValue());
		user.setYearOfBirth(this.year_box.getValue());
		user.setUserLogin(this.login_field.getText());
		user.setUserPassword(this.password_field.getText());

		if (this.radio_man.isSelected()) user.setSex(this.radio_man.getText());
		else user.setSex(this.radio_woman.getText());

		return user;

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
