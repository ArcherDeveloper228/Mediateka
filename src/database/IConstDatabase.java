package database;

public interface IConstDatabase {

	String URL = new String("jdbc:mysql://localhost:3306/mediateka");
	String CLIENT_NAME = new String("root");
	String CLIENT_PASSWORD = new String("Nikita09061999");
	String SQL_INSERT_USER = new String("INSERT INTO user(name, surname, birth_day, birth_month, birth_year,"
			+ " sex, login, password) VALUES(?,?,?,?,?,?,?,?)");
	String SQL_SELECT_USER = new String("SELECT * FROM user");
	
}
