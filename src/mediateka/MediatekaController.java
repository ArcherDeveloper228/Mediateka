package mediateka;

import java.io.File;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;

import client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * Class-controller for .fxml document "Mediateka.fxml"
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class MediatekaController {

	/** Property - client */
	private Client client;
	
	/** Collection - images */
	private List<Image> images;
	
	// ���������� ���� ��� �������������� ���������
	{ this.images = new LinkedList<>(); }
	
	@FXML
	private Button button_add;

	@FXML
	private Button button_exit;

	@FXML
	private Button button_delete;

	@FXML
	private TabPane tab_pane;

	@FXML
	private ImageView image_view;

	@FXML
	private ListView<String> images_list_view;

	@FXML
	private ListView<String> music_list_view;

	@FXML
	private ListView<String> films_list_view;

	@FXML
	private void initialize() {
		
		this.images_list_view.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		this.films_list_view.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		this.music_list_view.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		// ������������� ���������� ������� ��� ������ button_exit
		this.button_exit.setOnAction(event -> this.button_exit.getScene().getWindow().hide() );

		// ������������� ���������� ������� ��� ������ button_add
		this.button_add.setOnAction(event -> {

			// �������� ��� ������ ������ TabPane
			List<Tab> tabs = this.tab_pane.getTabs();
			// ��������� ��� ����������� ������
			List<File> files = null;
			String title_tab = null;
			
			for (Tab tab : tabs) {

				title_tab = tab.getText();

				switch (title_tab) {

				case "Images": if (tab.isSelected()) files = this.makeFileChooser("View Pictures", title_tab);
							   if (files != null) for (File file : files) this.images_list_view.getItems().add(file.getName());  
							   break;
				case "Music":  if (tab.isSelected()) files = this.makeFileChooser("View Music", title_tab); 
							   if (files != null) for (File file : files) this.music_list_view.getItems().add(file.getName()); 
							   break;
				case "Films":  if (tab.isSelected()) files = this.makeFileChooser("View Films", title_tab); 
							   if (files != null) for (File file : files) this.films_list_view.getItems().add(file.getName());  
							   break;

				}

			}

		});

		// ������������� ���������� ������� ��� ������ button_delete
		this.button_delete.setOnAction(event -> {



		});

	}

	/**
	 * This method make FileChooser window
	 * @param title_window value of the object String what contains information about title of window
	 * @param flag value of the object String what contains title of tab
	 * @return value of the collection List<File>
	 * */
	private final List<File> makeFileChooser(String title_window, String flag) {

		List<File> list = null;

		FileChooser file_chooser = new FileChooser();
		file_chooser.setTitle(title_window);

		switch (flag) {

		case "Images": file_chooser.getExtensionFilters().addAll(
					       new FileChooser.ExtensionFilter("All Images", "*.*"),
					       new FileChooser.ExtensionFilter("PNG Images", "*.png"),
					       new FileChooser.ExtensionFilter("JPG Images", "*.jpg"));
					   break;

		case "Music":  file_chooser.getExtensionFilters().addAll(
					       new FileChooser.ExtensionFilter("All Music", "*.*"),
					       new FileChooser.ExtensionFilter("MP3 Music", "*.mp3"));
					   break;

		case "Films":  file_chooser.getExtensionFilters().addAll(
						   new FileChooser.ExtensionFilter("All Films", "*.*"),
						   new FileChooser.ExtensionFilter("MP4 Films", "*.mp4"),
						   new FileChooser.ExtensionFilter("AVI Films", "*.avi"),
						   new FileChooser.ExtensionFilter("MKV Films", "*.mkv"),
						   new FileChooser.ExtensionFilter("MOV Films", "*.mov"));
			           break;

		}

		list = file_chooser.showOpenMultipleDialog(this.button_add.getScene().getWindow());

		return list;

	}

}
