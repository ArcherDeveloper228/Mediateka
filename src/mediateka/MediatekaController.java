package mediateka;

import java.io.File;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.FileChooser;

/**
 * Class-controller for .fxml document "Mediateka.fxml"
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class MediatekaController {

	@FXML
	private Button button_add;

	@FXML
	private Button button_exit;

	@FXML
	private Button button_delete;
	
	@FXML
	private TabPane tab_pane;
	
	@FXML
	private void initialize() {

		// устанавливаем обработчик события для кнопки button_exit
		this.button_exit.setOnAction(event -> this.button_exit.getScene().getWindow().hide() );
		
		// устанавливаем обработчик события для кнопки button_add
		this.button_add.setOnAction(event -> {
			
			// получаем все ячейки нашего TabPane
			List<Tab> tabs = this.tab_pane.getTabs();
			// коллекция для считываемых файлов
			List<File> files = null;
			
			for (Tab tab : tabs) {
				
				String title_tab = tab.getText();
				
				switch (title_tab) {
				
				case "Images": if (tab.isSelected()) files = this.makeFileChooser("View Pictures", title_tab); break;
				case "Music": if (tab.isSelected()) ; break;
				case "Films": if (tab.isSelected()) ; break;
				
				}
				
			}
			
			if (files == null) {
				
				System.out.println("Ничо не выбрал");
				return;
				
			}
			
			for (File file : files) {
				
				System.out.println(file.getAbsolutePath());
				
			}
			
		});
		
		// устанавливаем обработчик события для кнопки button_delete
		this.button_delete.setOnAction(event -> {
			
			
			
		});
		
	}
	
	/**
	 * 
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
					   
		case "Music": 
					  break;
					  
		case "Films": break;
		
		}
		
		list = file_chooser.showOpenMultipleDialog(this.button_add.getScene().getWindow());
		
		return list;
		
	}

}
