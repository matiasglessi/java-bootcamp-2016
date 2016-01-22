package services;

import java.util.ArrayList;

import shoppingCart.Product;

public interface ShoppingCartService {
	
	 public void addProduct(Product product);  
	 
	 public ArrayList<Product> getProducts();
	 
	 public void deleteProduct(Product product);
	 
	 public Product getLastProductAdded();
	 
}
