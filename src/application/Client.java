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
	
	/** Property - print_stream */
	private PrintStream print_stream;
	
	/** Property - buffered_reader */
	private BufferedReader buffered_reader;
	
	private ObjectOutputStream object_output_stream;
	
	// логический блок для обнуления объектов
	{
		
		this.socket = null;
		this.print_stream = null;
		this.buffered_reader = null;
		this.object_output_stream = null;
		
	}
	
	/**
	 * Make new object Client
	 * */
	public Client() {
		
		try {
			
			this.socket = new Socket(InetAddress.getLocalHost(), 9999);
			this.print_stream = new PrintStream(this.socket.getOutputStream());
			this.buffered_reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.object_output_stream = new ObjectOutputStream(this.socket.getOutputStream());
			
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
	
	public void registrationUser(User user) {
		
		try {
			this.object_output_stream.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method delete connection with server
	 * */
	public void closeConnection() {			
		
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
	
	/**
	 * This method return value of the object PrintStream
	 * @return value of the object PrintStream
	 * */
	public PrintStream getPrintStream() {
		
		return this.print_stream;
		
	}
	
	/**
	 * This method set value of the object PrintStream
	 * @param print_stream value of the object PrintStream
	 * */
	public void setPrintStream(PrintStream print_stream) {
		
		this.print_stream = print_stream;
		
	}
	
	/**
	 * This method return value of the object BufferedReader
	 * @return value of the object BufferedReader
	 * */
	public BufferedReader getBufferedReader() {
		
		return this.buffered_reader;
		
	}
	
	/**
	 * This method set value of the object BufferedReader
	 * @param buffered_reader value of the object BufferedReader
	 * */
	public void setBufferedReader(BufferedReader buffered_reader) {
		
		this.buffered_reader = buffered_reader;
		
	}
	
	public ObjectOutputStream getObjectOutputStream() {
		
		return this.object_output_stream;
		
	}
	
	public void setObjectOutputStream(ObjectOutputStream object_output_stream) {
		
		this.object_output_stream = object_output_stream;
		
	}
	
}
