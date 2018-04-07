package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import application.User;

/**
 * This class make connection with database mediateka
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class Database implements IConstDatabase {

	/** Property - statement */
	private Statement statement;

	/** Property - prepared_statement */
	private PreparedStatement prepared_statement;

	/** Property - result_set */
	private ResultSet result_set;

	/** Property - connection */
	private Connection connection;

	/** Make new object Database */
	public Database() {

		this.statement = null;
		this.prepared_statement = null;
		this.result_set = null;

		try {
			this.connection = (Connection) DriverManager.getConnection(URL,
					CLIENT_NAME, CLIENT_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method add user in database
	 * @param user it is object contains information about user
	 * */
	public void addUser(User user) {

		try {

			this.prepared_statement = (PreparedStatement) this.connection.prepareStatement(SQL_INSERT_USER);

			this.prepared_statement.setString(1, user.getName());
			this.prepared_statement.setString(2, user.getSurname());
			this.prepared_statement.setInt(3, user.getDayOfBirth());
			this.prepared_statement.setString(4, user.getMonthOfBirth());
			this.prepared_statement.setInt(5, user.getYearOfBirth());
			this.prepared_statement.setString(6, user.getSex());
			this.prepared_statement.setString(7, user.getUserLogin());
			this.prepared_statement.setInt(8, user.getUserPassword());

			this.prepared_statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// если объект PreparedStatement не null, то закрываем его
			if (this.prepared_statement != null) {

				try {
					this.prepared_statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}

	}

	/**
	 * This method get collection users from table user
	 * @return value of the table user
	 * */
	public List<User> getTable() {

		List<User> users = new ArrayList<>();

		try {

			this.statement = (Statement) this.connection.createStatement();
			this.result_set = this.statement.executeQuery(SQL_SELECT_USER);

			while (this.result_set.next()) users.add(this.makeUser());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// если объект ResultSet не null, то закрываем его
			if (this.result_set != null) {

				try {
					this.result_set.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			// если объект Statement не null, то закрываем его
			if (this.statement != null) {

				try {
					this.statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}

		return users;

	}

	private User makeUser() {

		User user = new User();

		try {

			user.setName(this.result_set.getString(2));
			user.setSurname(this.result_set.getString(3));
			user.setDayOfBirth(this.result_set.getInt(4));
			user.setMonthOfBirth(this.result_set.getString(5));
			user.setYearOfBirth(this.result_set.getInt(6));
			user.setSex(this.result_set.getString(7));
			user.setUserLogin(this.result_set.getString(8));
			user.setUserPassword(this.result_set.getInt(9));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;

	}

}
