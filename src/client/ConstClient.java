package client;

import application.User;

public interface ConstClient {

	boolean writeMessage(User user, String server_comand);
	String readMessage();
	
}
