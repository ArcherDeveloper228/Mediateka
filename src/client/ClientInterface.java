package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import com.google.gson.Gson;

import application.User;

public class ClientInterface implements ConstClient {

	/** Property - socket */
	private Socket socket;
	
	/** Property - print_stream */
	private PrintStream print_stream;
	
	/** Property - buffered_reader */
	private BufferedReader buffered_reader;
	
	/**
	 * Make new object ClientInterface
	 * */
	public ClientInterface() {
		
		this.socket = null;
		this.print_stream = null;
		this.buffered_reader = null;
		
	}
	
	public ClientInterface(Socket socket) {
		
		try {
			
			this.socket = socket;
			this.print_stream = new PrintStream(this.socket.getOutputStream());
			this.buffered_reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method write information into thread
	 * @param json 
	 * */
	@Override
	public boolean writeMessage(User user) {
		
		if (this.print_stream == null) return false;
		
		Gson json = new Gson();
		json.toJson(user);
		
		this.print_stream.println(json);
		
		return true;
		
	}
	
	@Override
	public String readMessage() {
		
		return new String();
		
	}
	
}
