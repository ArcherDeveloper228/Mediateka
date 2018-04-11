package application;

/**
 * This class contains user login and password
 * @author Nikita.Ustyushenko
 * @version 1.0
 *  */
public class User extends Person {

	/** Property - serialVersionUID */
	private static final long serialVersionUID = -9111318358823063322L;

	/** Property - user_login */
	private String user_login;

	/** Property - user_password */
	private int user_password;

	/**
	 * Make new object User
	 * */
	public User() {
		super();
		this.user_login = null;
		this.user_password = 0;

	}

	/**
	 * Make new object User
	 * @param name value contains information about user name
	 * @param surname value contains information about user surname
	 * @param day_of_birth value contains information about day of birth user
	 * @param month_of_birth value contains information about month of birth user
	 * @param year_of_birth value contains information about year of birth user
	 * @param sex value contains information about user sex
	 * @param user_login value contains information about user login
	 * @param user_password value contains information about user password
	 * */
	public User(String user_name, String user_surname, int day_of_birth, String month_of_birth,
			int year_of_birth, String sex, String user_login, int user_password) {

		super(user_name, user_surname, day_of_birth, month_of_birth, year_of_birth, sex);
		this.user_login = user_login;
		this.user_password = user_password;

	}

	@Override
	public String toString() {

		return new String(super.toString() + "Login: " + this.user_login + "\n" + "Password: " + this.user_password +
				"\n");

	}

	/**
	 * This method returns the value of the user login
	 * @return String value of the user login
	 * */
	public String getUserLogin() {

		return this.user_login;

	}

	/**
	 * This method sets value of the user login
	 * @param user_login value of the user login
	 * */
	public void setUserLogin(String user_login) {

		this.user_login = user_login;

	}

	/**
	 * This method returns the value of the user hash code password
	 * @return String value of the user hash code password
	 * */
	public int getUserPassword() {

		return this.user_password;

	}

	/**
	 * This method sets value of the user password
	 * @param user_password value of the user password
	 * */
	public void setUserPassword(int user_password) {

		this.user_password = user_password;

	}

	/**
	 * This method sets value of the user password
	 * @param user_password value of the user password
	 * */
	public void setUserPassword(String user_password) {

		this.user_password = user_password.hashCode();

	}

}
