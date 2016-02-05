package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import spring.database.DBConnection;
import spring.model.Product;

/**
 * This is the implementation the ProductDAO interface in order to control the
 * Product's database interactions.
 * 
 * @author Matias Glessi
 *
 */
public class ProductDAOImpl implements ProductDAO {

	public void create(Product product) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String insertTableSQL = "INSERT INTO Product" + "(id, name, category, price, stock) VALUES" + "(?,?,?,?,?)";

		preparedStatement = con.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setString(3, product.getCategory());
		preparedStatement.setDouble(4, product.getPrice());
		preparedStatement.setInt(5, product.getStock());

		preparedStatement.executeUpdate();

	}

	public void update(Product product) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String updateTableSQL = "UPDATE Product SET name = ? , category = ? , price = ? , stock = ? " + "WHERE id = ? ";

		preparedStatement = con.prepareStatement(updateTableSQL);
		preparedStatement.setString(1, product.getName());
		preparedStatement.setString(2, product.getCategory());
		preparedStatement.setDouble(3, product.getPrice());
		preparedStatement.setInt(4, product.getStock());
		preparedStatement.setInt(5, product.getId());

		preparedStatement.executeUpdate();

	}

	public void delete(Product product) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String deleteSQL = "DELETE FROM Product WHERE id = ? ";

		preparedStatement = con.prepareStatement(deleteSQL);
		preparedStatement.setInt(1, product.getId());

		preparedStatement.executeUpdate();
	}

	public ArrayList<Product> findByCategory(String category) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String query = "SELECT * FROM Product WHERE category = ? ";

		preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, category);

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Product> searchResults = new ArrayList<Product>();

		while (resultSet.next()) {
			Product product = new Product();

			product.setId(resultSet.getInt("id"));
			product.setName(resultSet.getString("name"));
			product.setCategory(resultSet.getString("category"));
			product.setPrice(resultSet.getDouble("price"));
			product.setStock(resultSet.getInt("stock"));

			searchResults.add(product);
		}

		return searchResults;
	}

	public ArrayList<Product> findByName(String name) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String query = "SELECT * FROM Product WHERE name = ? ";

		preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, name);

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Product> searchResults = new ArrayList<Product>();

		while (resultSet.next()) {
			Product product = new Product();

			product.setId(resultSet.getInt("id"));
			product.setName(resultSet.getString("name"));
			product.setCategory(resultSet.getString("category"));
			product.setPrice(resultSet.getDouble("price"));
			product.setStock(resultSet.getInt("stock"));

			searchResults.add(product);
		}

		return searchResults;
	}

	public Product exists(int productId) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String query = "SELECT * FROM Product WHERE id = ? ";

		preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, productId);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			Product productFinded = new Product();
			productFinded.setId(resultSet.getInt(1));
			productFinded.setName(resultSet.getString(2));
			productFinded.setCategory(resultSet.getString(3));
			productFinded.setPrice(resultSet.getDouble(4));
			productFinded.setStock(resultSet.getInt(5));

			return productFinded;
		} else {
			return null;
		}
	}

}
