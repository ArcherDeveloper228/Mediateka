package json;

import java.io.File;

import application.User;

public interface IParseUserInterface {

	String makeUserJson(User user, String command);
	UserComand parseUserJson(String user_json);
	String makeFileJson(File file, String command);
	FileCommand parseFileJson(String file_json);

}
