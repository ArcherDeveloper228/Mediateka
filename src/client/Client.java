package client;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;

import javafx.scene.control.Alert;

/**
 * This class create connection with server
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class Client {

	/** Property - port */
	//private static int port = 9999;
	private static int port;

	/** Property - address */
	//private static String address = new String("127.0.0.1");
	private static String ip_address;

	/** Property - client_interface */
	private ClientInterface client_interface;

	/** Property - socket */
	private Socket socket;

	/**
	 * Make new object Client
	 * */
	public Client() {

		this.socket = null;
		this.client_interface = null;

		try {

			this.socket = new Socket(InetAddress.getByName(ip_address), port);
			this.client_interface  = new ClientInterface(this.socket);

		} catch (ConnectException e1) {

			this.showDialogMessage("Attention", "Server doesn't answer!");
			System.exit(-1);

		} catch (NoRouteToHostException e2) {

			this.showDialogMessage("Attention", "Server doesn't answer!");
			System.exit(-1);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method make dialog message window
	 * @param title title dialog window
	 * @param message message dialog window
	 * */
	public void showDialogMessage(String title, String message) {

		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText("");
		alert.setContentText(message);
		alert.showAndWait();

	}

	/**
	 * This method close connection with socket
	 * */
	public void closeConnection() {

		// закрываем все созданные I/O потоки
		this.client_interface.closeConnection();

		// если сокет не null, то разрываем соединение с сервером
		if (this.socket != null) {

			try {
				this.socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * This method return value of the object ClientInterface
	 * @return value of the object ClientInterface
	 * */
	public ClientInterface getClientInterface() {

		return this.client_interface;

	}

	/**
	 * This method set value of the object ClientInterface
	 * @param client_interface value of the object ClientInterface
	 * */
	public void setClientInterface(ClientInterface client_interface) {

		this.client_interface = client_interface;

	}

	/**
	 * This method return value of the object Socket
	 * @return value of the object Socket
	 * */
	public Socket getSocket() {

		return this.socket;

	}

	/**
	 * This method set value of the object Socket
	 * @param socket value of the object socket
	 * */
	public void setSocket(Socket socket) {

		this.socket = socket;

	}
	
	/**
	 * This method return value of the port 
	 * @return port value of the port
	 * */
	public static int getPort() {
		
		return port;
		
	}
	
	/**
	 * This method set value of the port
	 * @param new_port value of the new port
	 * */
	public static void setPort(int new_port) {
		
		port = new_port;
		
	}
	
	/**
	 * This method return value of the object String 
	 * what contains information about ip address 
	 * @return value of the object String what contains information about ip address
	 * */
	public static String getIpAddress() {
		
		return ip_address;
		
	}
	
	/**
	 * This method set value of the object String
	 * what contains information about ip address
	 * @param new_ip_address value of the object String 
	 * what contains information about ip address
	 * */
	public static void setIpAddress(String new_ip_address) {
		
		ip_address = new String(new_ip_address);
		
	}

}
