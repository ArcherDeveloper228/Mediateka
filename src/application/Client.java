package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;

import javafx.scene.control.Alert;

/**
 * This class create connection with server 
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class Client {

	/** Property - socket */
	private Socket socket;
	
	/** Property - object_output_stream */
	private ObjectOutputStream object_output_stream;
	
	/** Property - print_stream */
	private PrintStream print_stream;
	
	/** Property - buffered_reader */
	private BufferedReader buffered_reader;
	
	// логический блок для обнуления объектов
	{
		
		this.socket = null;
		this.object_output_stream = null;
		this.print_stream = null;
		this.buffered_reader = null;
		
	}
	
	/**
	 * Make new object Client
	 * */
	public Client() {
		
		try {
			
			this.socket = new Socket(InetAddress.getLocalHost(), 9999);
			this.object_output_stream = (ObjectOutputStream) this.socket.getOutputStream();
			this.print_stream = new PrintStream(this.socket.getOutputStream());
			this.buffered_reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			
		} catch (ConnectException e) {
			
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Attention");
			alert.setHeaderText("");
			alert.setContentText("Server doesn't answer!");
			alert.showAndWait();
			System.exit(-1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method delete connection with server
	 * */
	public void closeConnection() {
		
		// если поток записи не null, то закрываем его
		if (this.object_output_stream != null) {
			
			try {
				this.object_output_stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}			
		
		// если поток записи не null, то закрываем его
		if (this.print_stream != null) this.print_stream.close();
		
		// если поток чтения не null, то закрываем его
		if (this.buffered_reader != null) {
			
			try {
				this.buffered_reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		// если сокет не null, то закрываем его
		if (this.socket != null) {
			
			try {
				this.socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} 	
		
	}
	
	

}
