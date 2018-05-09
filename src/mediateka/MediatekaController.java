package mediateka;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;

import application.User;
import client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import json.FileCommand;

/**
 * Class-controller for .fxml document "Mediateka.fxml"
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class MediatekaController {

	/** Property - user */
	private User user;

	/** Property - client */
	private Client client;

	/** Collection - images */
	private List<File> images;

	private List<File> music;

	private List<File> films;

	// логический блок дл€ инициализации коллекций
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

		// устанавливаем обработчик событи€ дл€ кнопки button_exit
		this.button_exit.setOnAction(event -> this.button_exit.getScene().getWindow().hide());

		// устанавливаем обработчик событи€ дл€ полей ListView
		this.images_list_view.setOnMouseClicked(event -> {

			// получаем объект String выбранного элемента пользователем
			String title_image = this.images_list_view.getSelectionModel().getSelectedItem();

			// проходим по списку с элементами и ищем совпадение
			for (File image : this.images) {

				// если совпаление найдено, то отображаем на картинку на экране
				if (image.getName().equals(title_image))
					try {
						this.image_view.setImage(new Image(image.toURI().toURL().toString()));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}

			}

		});

		// устанавливаем обработчик событи€ дл€ кнопки button_add
		this.button_add.setOnAction(event -> {

			// получаем все €чейки нашего TabPane
			List<Tab> tabs = this.tab_pane.getTabs();
			// коллекци€ дл€ считываемых файлов
			List<File> files = null;
			String title_tab = null;

			for (Tab tab : tabs) {

				// получаем название €чейки
				title_tab = tab.getText();

				switch (title_tab) {

				case "Images": if (tab.isSelected()) files = this.makeFileChooser("View Pictures", title_tab); else break;
							   if (files != null)
								   for (File file : files) {

									   if (this.checkFile(file, this.images)) {

										   this.showDialogMessage("Attention", "A file with name \"" + file.getName() + "\" already exists!");
										   continue;

									   }

									   this.addFile(file, this.user.getUserLogin(), title_tab);

								   }
							   break;
				case "Music":  if (tab.isSelected()) files = this.makeFileChooser("View Music", title_tab); else break;
							   if (files != null) for (File file : files) this.music_list_view.getItems().add(file.getName());
							   break;
				case "Films":  if (tab.isSelected()) files = this.makeFileChooser("View Films", title_tab); else break;
							   if (files != null) for (File file : files) this.films_list_view.getItems().add(file.getName());
							   break;

				}

			}

		});

		// устанавливаем обработчик событи€ дл€ кнопки button_delete
		this.button_delete.setOnAction(event -> {

			// получаем все €чейки TabPane
			List<Tab> tabs = this.tab_pane.getTabs();
			// название выбранного Tab
			String title_tab = null;

			for (Tab tab : tabs) {

				// получаем название €чейки
				title_tab = tab.getText();

				switch (title_tab) {

				case "Images":  if (tab.isSelected())
									this.deleteElement(this.images_list_view.getSelectionModel().getSelectedItem() ,title_tab);
								break;
				case "Music":
								break;
				case "Films":
								break;

				}

			}

		});

	}

	/**
     * This method creates dialog window and prints information
     * @param title value of the window title
     * @param message value of the information message
     * */
	private final void showDialogMessage(String title, String message) {

    	Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText("");
		alert.setContentText(message);
		alert.showAndWait();

    }

	private boolean addFile(File file, String user_login, String flag) {

		//FileCommand file_command = null;

		switch (flag) {

		case "Images": // отправл€ем файл серверу
			   		   this.client = new Client();
			   		   this.client.getClientInterface().writeFile(file, user_login, "AddImage");
			   		   // ждем ответа сервера
			   		   this.images_list_view.getItems().add(file.getName());
					   // добавл€ем объект File в коллекцию images
					   this.images.add(file);
					   break;
		case "Music": break;
		case "Films": break;

		}

		return true;

	}

	/**
	 * This method check duplicate files
	 * @param file value of the object File
	 * @param files collection
	 * @return boolean value
	 * */
	private final boolean checkFile(File file, List<File> files) {

		boolean result = false;

		for (File new_file : files)
			if (new_file.getName().equals(file.getName())) result = true;

		return result;

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

	/**
	 * This method delete element from ListView
	 * @param element value of the object String what contains information about element
	 * @param flag value of the object String what contains information about flag for action
	 * @return boolean value
	 * */
	private final boolean deleteElement(String element, String flag) {

		boolean result = true;

		switch (flag) {

		case "Images": result = this.images_list_view.getItems().remove(element);
					   for (File image : this.images)
					       if (image.getName().equals(element))
					    	   if (!this.images.remove(image))
					    		   return false;
					   break;

		case "Music":  break;
		case "Films":  break;

		}

		return result;

	}

	/**
	 * This method set value of the object User
	 * @param user value of the object User
	 * */
	public void setUser(User user) {

		this.user = user;

	}

	/**
	 * This method return value of the object User
	 * @return value of the object User
	 * */
	public User getUser() {

		return this.user;

	}

}
