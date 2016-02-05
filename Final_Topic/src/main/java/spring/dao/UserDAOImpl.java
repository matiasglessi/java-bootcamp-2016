package spring.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import spring.database.DBConnection;
import spring.model.User;

/**
 * This is the implementation the UserDAO interface in order to control the
 * User's database interactions.
 * 
 * @author Matias Glessi
 *
 */
public class UserDAOImpl implements UserDAO {

	public User isValidUser(String username, String password) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String query = "SELECT * FROM User WHERE username = ? AND password = ?";

		preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			User userFinded = new User();
			userFinded.setFirst_name(resultSet.getString(1));
			userFinded.setLast_name(resultSet.getString(2));
			userFinded.setUsername(resultSet.getString(3));
			userFinded.setPassword(resultSet.getString(4));
			return userFinded;

		} else {
			return null;
		}

	}

	public void create(User user) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String insertTableSQL = "INSERT INTO User" + "(first_name, last_name, username, password) VALUES" + "(?,?,?,?)";

		preparedStatement = con.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, user.getFirst_name());
		preparedStatement.setString(2, user.getLast_name());
		preparedStatement.setString(3, user.getUsername());
		preparedStatement.setString(4, user.getPassword());

		preparedStatement.executeUpdate();

	}

	public void update(User user) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String updateTableSQL = "UPDATE User SET first_name = ? , last_name = ? , password = ? " + "WHERE username = ?";

		preparedStatement = con.prepareStatement(updateTableSQL);
		preparedStatement.setString(1, user.getFirst_name());
		preparedStatement.setString(2, user.getLast_name());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setString(4, user.getUsername());

		preparedStatement.executeUpdate();

	}

	public void delete(User user) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String deleteSQL = "DELETE FROM User WHERE username = ?";

		preparedStatement = con.prepareStatement(deleteSQL);
		preparedStatement.setString(1, user.getUsername());

		preparedStatement.executeUpdate();

	}

	public User exists(String username) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String query = "SELECT * FROM User WHERE username = ? ";

		preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, username);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			User userFinded = new User();
			userFinded.setFirst_name(resultSet.getString(1));
			userFinded.setLast_name(resultSet.getString(2));
			userFinded.setUsername(resultSet.getString(3));
			userFinded.setPassword(resultSet.getString(4));
			return userFinded;

		} else {
			return null;
		}

	}

}
