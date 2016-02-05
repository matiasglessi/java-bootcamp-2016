package spring.service;

import java.sql.SQLException;

import spring.model.User;

/**
 * This interface provides the control of the User's services. Provides methods
 * that interact with the users.
 * 
 * @author Matias Glessi
 *
 */
public interface UserService {

	/**
	 * This method validates if the user is exists or not.
	 * 
	 * @param user
	 *            The User's username
	 * @param pass
	 *            The User's password
	 * @return The user if exists. If not, null.
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public User isValidUser(String user, String pass) throws ClassNotFoundException, SQLException;

	/**
	 * This method creates a new User.
	 * 
	 * @param user
	 *            The user to be created
	 * @return The user created or null if already exists
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public User create(User user) throws ClassNotFoundException, SQLException;

	/**
	 * This method updates an existing User.
	 * 
	 * @param user
	 *            The user to be updated
	 * @return The user updated or null if it does not exists
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public User update(User user) throws ClassNotFoundException, SQLException;

	/**
	 * This method deletes an existing User.
	 * 
	 * @param user
	 *            The user to be deleted
	 * @return The user deleted or null if it does not exists
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public User delete(User user) throws ClassNotFoundException, SQLException;

}
