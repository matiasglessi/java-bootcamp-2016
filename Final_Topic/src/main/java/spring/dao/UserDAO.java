package spring.dao;

import java.sql.SQLException;

import spring.model.User;

/**
 * This interface provides the control of the User's Data Access Object.
 * Providing methods such as create, update, delete and specifics validations in
 * order to obtain information from the database.
 * 
 * @author Matias Glessi
 *
 */
public interface UserDAO {

	/**
	 * This method validates if the username and password exists in the
	 * database.
	 * 
	 * @param user
	 *            The user's username.
	 * @param pass
	 *            The user's password
	 * @return The user if finded. Or null, if no product was found.
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public User isValidUser(String user, String pass) throws SQLException, ClassNotFoundException;

	/**
	 * This method inserts a new User in the database.
	 * 
	 * @param user
	 *            The new user to be inserted
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public void create(User user) throws SQLException, ClassNotFoundException;

	/**
	 * This method updates an existing User in the database.
	 * 
	 * @param user
	 *            The user to be updated
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public void update(User user) throws SQLException, ClassNotFoundException;

	/**
	 * This method deletes an existing User from the database
	 * 
	 * @param user
	 *            The user to be deleted
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public void delete(User user) throws SQLException, ClassNotFoundException;

	/**
	 * This method searches the existance of an User in the database, and
	 * returns it.
	 * 
	 * @param username
	 *            The user's username to be searched
	 * @return The user if finded. Or null, if no user was found.
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public User exists(String username) throws SQLException, ClassNotFoundException;

}
