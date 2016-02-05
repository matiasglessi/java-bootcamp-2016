package spring.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import spring.dao.ProductDAO;
import spring.dao.ProductDAOImpl;
import spring.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	ProductDAO productDAO = new ProductDAOImpl();

	public Product create(Product product) throws ClassNotFoundException, SQLException {
		if (productDAO.exists(product.getId()) == null) {
			productDAO.create(product);
			return product;
		}
		return null;
	}

	public Product update(Product product) throws ClassNotFoundException, SQLException {
		if (productDAO.exists(product.getId()) != null) {
			productDAO.update(product);
			return product;
		}
		return null;

	}

	public Product delete(Product product) throws ClassNotFoundException, SQLException {
		if (productDAO.exists(product.getId()) != null) {
			productDAO.delete(product);
			return product;
		}
		return null;
	}

	public ArrayList<Product> findByCategory(String category) throws ClassNotFoundException, SQLException {
		return productDAO.findByCategory(category);
	}

	public ArrayList<Product> findByName(String name) throws ClassNotFoundException, SQLException {
		return productDAO.findByName(name);
	}

}
