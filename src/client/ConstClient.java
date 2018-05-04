package client;

import java.io.File;

import application.User;
import json.FileCommand;
import json.UserComand;

public interface ConstClient {

	boolean writeMessage(User user, String server_comand);
	UserComand readMessage();
	boolean writeFile(File file, String server_command);
	FileCommand readFile();

}
