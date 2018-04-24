package client;

import application.User;
import json.UserComand;

public interface ConstClient {

	boolean writeMessage(User user, String server_comand);
	UserComand readMessage();

}
