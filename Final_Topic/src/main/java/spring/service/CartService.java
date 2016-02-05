package spring.service;

import java.sql.SQLException;

import spring.model.Cart;
import spring.model.Product;

/**
 * This interface provides the control of the Cart's services. Provides methods
 * that interact with the cart.
 * 
 * @author Matias Glessi
 *
 */
public interface CartService {

	/**
	 * This method add a new Product to the cart.
	 * 
	 * @param cart
	 *            The cart where the product will be added
	 * @param product
	 *            The product to be added
	 * @param quantity
	 *            The quantity of the product
	 * @return The added product
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public Product addProduct(Cart cart, Product product, int quantity) throws ClassNotFoundException, SQLException;

	/**
	 * This method updates an existing Product in the cart.
	 * 
	 * @param cart
	 *            The cart where the product will be updated
	 * @param product
	 *            The product to be updated
	 * @param quantity
	 *            The quantity of the product
	 * @return The updated product
	 */
	public Product updateProduct(Cart cart, Product product, int quantity);

	/**
	 * This method deletes an existing Product in the cart.
	 * 
	 * @param cart
	 *            The cart where the product will be deleted
	 * @param product
	 *            The product to be deleted
	 * @return The deleted product
	 */
	public Product deleteProduct(Cart cart, Product product);

	/**
	 * This method buy all the products from the current cart, modify the
	 * product's stock and cleans the cart afterwards.
	 * 
	 * @param cart
	 *            The cart that has the list of products
	 * @param username
	 *            The User's username
	 * @return true if the bought was successful and false if the stocks were
	 *         insufficient
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public boolean buyProducts(Cart cart, String username) throws ClassNotFoundException, SQLException;

	/**
	 * This method saves the current state of the cart.
	 * 
	 * @param username
	 *            The User's username
	 * @param cart
	 *            The cart that is going to be stored.
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public void saveCart(String username, Cart cart) throws ClassNotFoundException, SQLException;

	/**
	 * This method deletes all the existing products in the User's Cart.
	 * 
	 * @param username
	 *            The User's username.
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public void deleteCartItems(String username) throws ClassNotFoundException, SQLException;

	/**
	 * This method returns the saved state of the cart.
	 * 
	 * @param username
	 *            The User's username
	 * @return The Cart saved
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public Cart getSavedCart(String username) throws ClassNotFoundException, SQLException;

}
