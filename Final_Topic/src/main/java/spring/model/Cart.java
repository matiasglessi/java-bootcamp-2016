package spring.model;

import java.util.HashMap;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class represents an actual Shopping Cart, as it has its own list of
 * products and their's quantities.
 * 
 * @author Matias Glessi
 *
 */
@ApiModel(value = "Cart entity", description = "Complete data of an entity Cart")
public class Cart {

	@ApiModelProperty(value = "Cart's list of products", required = true)
	private HashMap<Product, Integer> products;

	/**
	 * Creates the cart and it's list.
	 */
	public Cart() {
		products = new HashMap<Product, Integer>();
	}

	/**
	 * This method add a Product element to the shopping cart. If it exists in
	 * the cart just updates its quantity.
	 * 
	 * @param product
	 *            The product to be added
	 * @param quantity
	 *            The quantity of the product to be added
	 * @return The added product
	 */
	public Product addProduct(Product product, int quantity) {
		if (products.get(product) == null) {
			products.put(product, quantity);
			return product;
		} else {
			products.replace(product, quantity);
			return product;
		}
	}

	/**
	 * This method deletes a Product from the shopping cart.
	 * 
	 * @param product
	 *            The product to be deleted
	 * @return The deleted product.
	 */
	public Product deleteProduct(Product product) {
		products.remove(product);
		return product;
	}

	/**
	 * This method updates a Product from the shopping cart.
	 * 
	 * @param product
	 *            The product to be updated
	 * @param quantity
	 *            The quantity of the product to be updated
	 * @return The product updated
	 */
	public Product updateProduct(Product product, int quantity) {
		products.replace(product, quantity);
		return product;
	}

	/**
	 * This method returns the list of existing products in the Cart.
	 * 
	 * @return The list of products
	 */
	public HashMap<Product, Integer> getProducts() {
		return products;
	}

	/**
	 * This method cleans the cart by deleting all of its items.
	 */
	public void cleanProducts() {
		products = new HashMap<Product, Integer>();
	}
}
