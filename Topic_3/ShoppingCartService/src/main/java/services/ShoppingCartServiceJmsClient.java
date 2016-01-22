package services;

import java.util.ArrayList;

import shoppingCart.Cart;
import shoppingCart.Product;

public class ShoppingCartServiceJmsClient implements ShoppingCartService {

	ShoppingCartService jmsObject;
	
	public ShoppingCartServiceJmsClient() {
		//jmsObject = code to get the reference to ShoppingCart Service from the jms call  
	}
	
	public void addProduct(Product product) {
		jmsObject.addProduct(product);
	}

	public ArrayList<Product> getProducts() {
		return jmsObject.getProducts();
	}

	public void deleteProduct(Product product) {
		jmsObject.deleteProduct(product);
	}

	public Product getLastProductAdded() {
		return jmsObject.getLastProductAdded();
	}

}
