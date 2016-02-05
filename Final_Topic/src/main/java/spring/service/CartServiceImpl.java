package spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import spring.dao.CartDAO;
import spring.dao.CartDAOImpl;
import spring.dao.ProductDAO;
import spring.dao.ProductDAOImpl;
import spring.model.Cart;
import spring.model.Product;

@Service
public class CartServiceImpl implements CartService {

	ProductDAO productDAO = new ProductDAOImpl();
	CartDAO cartDAO = new CartDAOImpl();

	public Product addProduct(Cart cart, Product product, int quantity) throws ClassNotFoundException, SQLException {
		if (productDAO.exists(product.getId()) != null) {
			cart.addProduct(product, quantity);
			return product;
		}
		return null;
	}

	public Product updateProduct(Cart cart, Product product, int quantity) {
		return cart.updateProduct(product, quantity);
	}

	public Product deleteProduct(Cart cart, Product product) {
		return cart.deleteProduct(product);
	}

	public void saveCart(String username, Cart cart) throws ClassNotFoundException, SQLException {
		this.deleteCartItems(username);
		cartDAO.save(username, cart);
	}

	public void deleteCartItems(String username) throws ClassNotFoundException, SQLException {
		cartDAO.delete(username);
	}

	public boolean buyProducts(Cart cart, String username) throws ClassNotFoundException, SQLException {
		HashMap<Product, Integer> products = cart.getProducts();
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			if (entry.getValue() > entry.getKey().getStock()) {
				return false;
			}
		}
		this.modifyProductsStock(cart);
		this.deleteCartItems(username);
		cart.cleanProducts();
		return true;

	}

	private void modifyProductsStock(Cart cart) throws ClassNotFoundException, SQLException {
		HashMap<Product, Integer> products = cart.getProducts();
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			Product product = entry.getKey();
			product.setStock(product.getStock() - entry.getValue());
			productDAO.update(product);
		}
	}

	public Cart getSavedCart(String username) throws ClassNotFoundException, SQLException {
		return cartDAO.getCart(username);
	}
}
