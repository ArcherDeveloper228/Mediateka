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
public class Authorization extends Stage {
	
	/** Property - TITLE_WINDOW */
	private final String TITLE_WINDOW;
	
	/** Property - TITLE_IMAGE */
	private final String TITLE_IMAGE;
	
	/** Property - image */
	private final Image image;
	
	private AnchorPane pane;
	
	// логический блок для инициализации константных свойств
	{ 
		
		this.TITLE_WINDOW = new String("Authorization"); 
		this.TITLE_IMAGE = new String("cd.png");
		this.image = new Image(this.getClass().getResourceAsStream(this.TITLE_IMAGE));
	
	}
	
	/** Make new window for authorization  */
	public Authorization() {
		
		try {
			this.pane = (AnchorPane)FXMLLoader.load(Authorization.class.getResource("Authorization.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// задаем параметры окна авторизации пользователя (название, сцена, размеры)
		super.setMaxHeight(700);
		super.setMaxWidth(900);
		super.setMinHeight(400);
		super.setMinWidth(600);
		super.getIcons().add(this.image);
		super.setTitle(this.TITLE_WINDOW);
		super.setScene(new Scene(this.pane));
		super.show();
		
	}

}
