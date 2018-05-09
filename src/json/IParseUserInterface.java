package json;

import application.User;

public interface IParseUserInterface {

	String makeUserJson(User user, String command);
	UserComand parseUserJson(String user_json);
	String makeFileJson(byte[] bytes, String file_name, String user_login, String command);
	FileCommand parseFileJson(String file_json);

}
