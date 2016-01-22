package services;

import java.util.ArrayList;

import shoppingCart.Cart;
import shoppingCart.Product;

public class ShoppingCartWebService implements ShoppingCartService {
	
	ShoppingCartService implementation = new Cart();  

	public void addProduct(Product product) {
		implementation.addProduct(product);
	}

	public ArrayList<Product> getProducts() {
		return implementation.getProducts();
	}

	public void deleteProduct(Product product) {
		implementation.deleteProduct(product);	
	}

	public Product getLastProductAdded() {
		return implementation.getLastProductAdded();
	}

}
