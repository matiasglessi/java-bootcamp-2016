package spring.dao;

import java.sql.SQLException;

import spring.model.Cart;

/**
 * This interface provides the control of the Cart's Data Access Object.
 * Providing methods add, delete and obtain information to and from the
 * database.
 * 
 * @author Matias Glessi
 *
 */
public interface CartDAO {

	/**
	 * This method saves all the Cart information in the database.
	 * 
	 * @param username
	 *            The user's username
	 * @param cart
	 *            The user's cart
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public void save(String username, Cart cart) throws ClassNotFoundException, SQLException;

	/**
	 * This method deletes all the user items present in the database.
	 * 
	 * @param username
	 *            The user's username
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public void delete(String username) throws ClassNotFoundException, SQLException;

	/**
	 * This method returns the User's cart from the database.
	 * 
	 * @param username
	 * @return The user's cart
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Cart getCart(String username) throws ClassNotFoundException, SQLException;

}
