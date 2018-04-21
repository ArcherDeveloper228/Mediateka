package json;

import application.User;

public interface IParseUserInterface {

	String makeUserJson(User user, String command);
	UserComand parseUserJson(String user_json);

}
