package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import spring.database.DBConnection;
import spring.model.Cart;
import spring.model.Product;

/**
 * This is the implementation the CartDAO interface in order to control the
 * Cart's database interactions.
 * 
 * @author Matias Glessi
 *
 */
public class CartDAOImpl implements CartDAO {

	private ProductDAO productDAO = new ProductDAOImpl();

	public void save(String username, Cart cart) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();

		HashMap<Product, Integer> products = cart.getProducts();
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {

			PreparedStatement preparedStatement;

			String insertTableSQL = "INSERT INTO Cart" + "(username, id_product, quantity) VALUES" + "(?,?,?)";

			preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, username);
			preparedStatement.setLong(2, entry.getKey().getId());
			preparedStatement.setInt(3, entry.getValue());

			preparedStatement.executeUpdate();
		}
	}

	public void delete(String username) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String deleteTableSQL = "DELETE FROM Cart WHERE username = ? ";

		preparedStatement = con.prepareStatement(deleteTableSQL);
		preparedStatement.setString(1, username);

		preparedStatement.executeUpdate();
	}

	public Cart getCart(String username) throws ClassNotFoundException, SQLException {
		Cart cart = new Cart();
		Connection con = DBConnection.getConnection();

		PreparedStatement preparedStatement;

		String query = "SELECT * FROM Cart WHERE username = ? ";

		preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, username);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			cart.addProduct(productDAO.exists(resultSet.getInt(2)), resultSet.getInt(3));
		}

		return cart;
	}

}
