package registration;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * This class contains information about window for registration user
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class Registration extends Stage implements ConstRegistration{

	/** Property - image */
	private final Image image;

	/** Property - pane */
	private AnchorPane pane;

	/** Make new window for registration */
	public Registration() {

		this.image = new Image(this.getClass().getResourceAsStream(TITLE_IMAGE));

		try {
			this.pane = (AnchorPane)FXMLLoader.load(Registration.class.getResource(TITLE_DOC));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// задаем параметры окна регистрации пользователя(название, сцена, запрет на растягивание окна)
		super.getIcons().add(this.image);
		super.setResizable(false);
		super.setTitle(TITLE_WINDOW);
		super.setScene(new Scene(this.pane));
		super.show();

	}

}
