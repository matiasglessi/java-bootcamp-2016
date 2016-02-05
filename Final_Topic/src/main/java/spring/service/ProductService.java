package spring.service;

import java.sql.SQLException;
import java.util.ArrayList;

import spring.model.Product;

/**
 * This interface provides the control of the Product's services. Provides
 * methods that interact with the products.
 * 
 * @author Matias Glessi
 *
 */
public interface ProductService {

	/**
	 * This method creates a new Product.
	 * 
	 * @param product
	 *            The product to be created
	 * @return The created product
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public Product create(Product product) throws ClassNotFoundException, SQLException;

	/**
	 * This method updates an existing Product.
	 * 
	 * @param produc
	 *            The product to be updated
	 * @return The updated product
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public Product update(Product product) throws ClassNotFoundException, SQLException;

	/**
	 * This method deletes an existing Product.
	 * 
	 * @param produc
	 *            The product to be deleted
	 * @return The deleted product
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public Product delete(Product product) throws ClassNotFoundException, SQLException;

	/**
	 * This method returns a list of all the products that match the given
	 * category.
	 * 
	 * @param category
	 *            The category parameter for the search
	 * @return A list of product
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public ArrayList<Product> findByCategory(String category) throws ClassNotFoundException, SQLException;

	/**
	 * This method returns a list of all the products that match the given name.
	 * 
	 * @param name
	 *            The name parameter for the search
	 * @return A list of product
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	public ArrayList<Product> findByName(String name) throws ClassNotFoundException, SQLException;

}
