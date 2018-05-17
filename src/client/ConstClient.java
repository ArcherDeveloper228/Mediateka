package client;

import java.io.File;

import application.User;
import json.Container;
import json.UserComand;

public interface ConstClient {

	boolean writeMessage(User user, String server_command);
	UserComand readMessage();
	boolean writeFile(File file, String user_login, String server_command);
	Container readFile();

}
