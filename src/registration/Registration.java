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
public class Registration extends Stage {

	/** Property - TITLE_WINDOW */
	private final String TITLE_IMAGE;
	
	/** Property - TITLE_IMAGE */
	private final String TITLE_WINDOW;
	
	/** Property - image */
	private final Image image;
	
	private AnchorPane pane;
	
	// логический блок для инициализации константных свойств окна
	{ 
		
		this.TITLE_WINDOW = new String("Registration"); 
		this.TITLE_IMAGE = new String("cd.png");
		this.image = new Image(this.getClass().getResourceAsStream(this.TITLE_IMAGE));
		
	}
	
	/** Make new window for registration */
	public Registration() {
		
		try {
			this.pane = (AnchorPane)FXMLLoader.load(Registration.class.getResource("Registration.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// задаем параметры окна регистрации пользователя(название, сцена, запрет на растягивание окна)
		super.getIcons().add(this.image);
		super.setResizable(false);
		super.setTitle(this.TITLE_WINDOW);
		super.setScene(new Scene(this.pane));
		super.show();
		
	}
	
}
