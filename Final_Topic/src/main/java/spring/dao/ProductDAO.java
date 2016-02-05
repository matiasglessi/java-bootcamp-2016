package spring.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import spring.model.Product;

/**
 * This interface provides the control of the Product's Data Access Object.
 * Providing methods such as create, update, delete and specifics searchs in
 * order to obtain information from the database.
 * 
 * @author Matias Glessi
 *
 */
public interface ProductDAO {

	/**
	 * This method inserts a new Product in the database.
	 * 
	 * @param product
	 *            The new product to be inserted
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public void create(Product product) throws SQLException, ClassNotFoundException;

	/**
	 * This method updates an existing Product in the database.
	 * 
	 * @param product
	 *            The product to be updated
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public void update(Product product) throws SQLException, ClassNotFoundException;

	/**
	 * This method deletes an existing Product from the database
	 * 
	 * @param product
	 *            The product to be deleted
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public void delete(Product product) throws SQLException, ClassNotFoundException;

	/**
	 * This method searchs in the database and returns the products that has the
	 * same category.
	 * 
	 * @param category
	 *            The category to be searched
	 * @return A list of products
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public ArrayList<Product> findByCategory(String category) throws SQLException, ClassNotFoundException;

	/**
	 * This method searchs in the database and returns the products that has the
	 * same name.
	 * 
	 * @param name
	 *            The name to be searched
	 * @return A list of products
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public ArrayList<Product> findByName(String name) throws SQLException, ClassNotFoundException;

	/**
	 * This method searches the existance of a product in the database, and
	 * returns it.
	 * 
	 * @param productId
	 *            The product's id to be searched
	 * @return The product if finded. Or null, if no product was found.
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public Product exists(int productId) throws SQLException, ClassNotFoundException;

}
