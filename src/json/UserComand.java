package json;

import application.User;

/**
 * This class contains object User and command
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class UserComand {

	/** Property - command */
	private String command;
	
	/** Property - user */
	private User user;
	
	/**
	 * Make new object UserComand
	 * */
	public UserComand() {
		
		this.command = new String("Wait");
		this.user = null;
		
	}
	
	/**
	 * Make new object UserComand
	 * @param user value of the object User
	 * @param command this String object contains information about command
	 * */
	public UserComand(User user, String command) {
		
		this.user = user;
		this.command = command;
		
	}
	
	/**
	 * This method return value of the String object command
	 * @return value of the String object
	 * */
	public String getComand() {
		
		return this.command;
		
	}
	
	/**
	 * This method set value of the String object command
	 * @param command value of the String object
	 * */
	public void setComand(String command) {
		
		this.command = command;
		
	}
	
	/**
	 * This method get value of the object User
	 * @return value of the object User
	 * */
	public User getUser() {
		
		return this.user;
		
	}
	
	/**
	 * This method set value of the object User
	 * @param user value of the object User
	 * */
	public void setUser(User user) {
		
		this.user = user;
		
	} 
	
}
  