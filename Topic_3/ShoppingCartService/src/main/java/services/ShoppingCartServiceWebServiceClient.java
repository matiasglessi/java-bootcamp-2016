package services;

import java.util.ArrayList;
import shoppingCart.Product;

public class ShoppingCartServiceWebServiceClient implements ShoppingCartService {
	
	ShoppingCartService webService;
	
	public ShoppingCartServiceWebServiceClient(){
		// webService = code to get the reference to ShoppingCartService from the webservice call
	}
   
	public void addProduct(Product product) {
		webService.addProduct(product);
	}

	public ArrayList<Product> getProducts() {
		return webService.getProducts();
	}

	public void deleteProduct(Product product) {
		webService.deleteProduct(product);		
	}

	public Product getLastProductAdded() {
		return webService.getLastProductAdded();
	}

}
