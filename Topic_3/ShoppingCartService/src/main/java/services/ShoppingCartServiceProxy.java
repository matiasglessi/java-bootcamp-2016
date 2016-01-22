package services;

import java.util.ArrayList;

import shoppingCart.Product;

public class ShoppingCartServiceProxy implements ShoppingCartService {
	
	private ShoppingCartService cartService;

	
	public ShoppingCartServiceProxy(ShoppingCartService cartService) {
		this.cartService = cartService; 
	}

	public void addProduct(Product product) {
		cartService.addProduct(product);

	}

	public ArrayList<Product> getProducts() {
		return cartService.getProducts();
		
	}

	public void deleteProduct(Product product) {
		cartService.deleteProduct(product);
		
	}

	public Product getLastProductAdded() {
		return cartService.getLastProductAdded();
	}

	
	
}
