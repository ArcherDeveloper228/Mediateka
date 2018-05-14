package client;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * This class make window "ServerConnection"
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class ClientConnection extends Stage {

	/** Property - TITLE_WINDOW */
	private final String TITLE_WINDOW;
	
	/** Property - pane */
	private AnchorPane pane;
	
	// логический блок для инициализации константы
	{ this.TITLE_WINDOW = new String("ServerConnection"); }
	
	/**
	 * Make new window "ServerConnection"  
	 * */
	public ClientConnection() {
		
		try {
			this.pane = (AnchorPane)FXMLLoader.load(ClientConnection.class.getResource("ClientConnection.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		super.setScene(new Scene(this.pane));
		super.setResizable(false);
		super.setTitle(TITLE_WINDOW);
		super.show();
		
	}
	
}
