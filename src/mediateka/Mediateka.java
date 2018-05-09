package mediateka;

import java.io.IOException;

import application.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Mediateka extends Stage {

	/** Property - TITLE_WINDOW */
	private final String TITLE_WINDOW;

	/** Property - TITLE_IMAGE */
	private final String TITLE_IMAGE;

	/** Property - image */
	private Image image;

	/** Property - pane */
	private AnchorPane pane;

	// логический блок для инициализации константного поля
	{

		this.TITLE_WINDOW = new String("USTMedia");
		this.TITLE_IMAGE = new String("cd.png");
		this.image = new Image(Mediateka.class.getResourceAsStream(this.TITLE_IMAGE));

	}

	/** 
	 * Make new window Mediateka 
	 * @param user value of the object User what contains information user
	 * */
	public Mediateka(User user) {

		try {

			FXMLLoader loader = new FXMLLoader(Mediateka.class.getResource("Mediateka.fxml"));
			this.pane = loader.load();
			
			// передача объекта User контроллеру
			MediatekaController controller = loader.<MediatekaController>getController();
			controller.setUser(user);
				
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.getIcons().add(this.image);
		super.setResizable(false);
		super.setTitle(this.TITLE_WINDOW);
		super.setScene(new Scene(this.pane));
		super.show();

	}

}
