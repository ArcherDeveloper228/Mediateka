package authorization;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * This class contains information about window for authorization user
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class Authorization extends Stage implements ConstAuthorization {
	
	/** Property - image */
	private final Image image;
	
	/** Property - pane */
	private AnchorPane pane;
	
	/** Make new window for authorization  */
	public Authorization() {
		
		this.image = new Image(this.getClass().getResourceAsStream(TITLE_IMAGE));
		
		try {
			this.pane = (AnchorPane)FXMLLoader.load(Authorization.class.getResource(TITLE_DOC));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// задаем параметры окна авторизации пользователя (название, сцена, размеры)
		super.setMaxHeight(MAX_HEIGHT);
		super.setMaxWidth(MAX_WIDTH);
		super.setMinHeight(MIN_HEIGHT);
		super.setMinWidth(MIN_WIDTH);
		super.getIcons().add(this.image);
		super.setTitle(TITLE_WINDOW);
		super.setScene(new Scene(this.pane));
		super.show();
		
	}

}
