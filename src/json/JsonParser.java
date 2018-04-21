package json;

import com.google.gson.Gson;

import application.User;

/**
 * This class make and parse Gson objects
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class JsonParser implements IParseUserInterface {

	/** Property - gson */
	private final Gson gson;
	
	/**
	 * Make new object JsonParser
	 * */
	public JsonParser() {
		
		this.gson = new Gson();
		
	}
	
	// переопределение метода создания json объекта UserComand
	@Override 
	public String makeUserJson(User user, String command) {
		
		UserComand user_command = new UserComand(user, command);
		
		return new String(this.gson.toJson(user_command));
		
	}
	
	// переопределение метода парсинга json строки
	@Override 
	public UserComand parseUserJson(String user_json) {
		
		return this.gson.fromJson(user_json, UserComand.class);
		
	}
	
	/**
	 * This method return value of the object Gson
	 * @return value of the object Gson
	 * */
	public Gson getGson() {
		
		return this.gson;
		
	}
	
}
