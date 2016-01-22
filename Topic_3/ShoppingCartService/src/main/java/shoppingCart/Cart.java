package shoppingCart;

import java.util.ArrayList;
import java.util.Iterator;

import services.ShoppingCartService;

public class Cart implements ShoppingCartService {
	
	private ArrayList<Product> products;
		
	public Cart(){
		this.products = new ArrayList<Product>();
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	
	public void addProduct(Product product){
		if(!products.contains(product)){
			products.add(0,product);
		}
		else{
			products.remove(product);
			products.add(0, product);
		}			
	}
		
	public int getTotalItems() {
		return products.size();
	}

	public void deleteProduct(Product product) {
		products.remove(product);
	}

	public Product getLastProductAdded() {
		return products.get(0);
	}


}
