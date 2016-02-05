package spring.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class represents an actual Product.
 * 
 * @author Matias Glessi
 *
 */
@ApiModel(value = "Product entity", description = "Complete data of an entity Product")
public class Product {

	@ApiModelProperty(value = "Product's id", required = true)
	private int id;
	@ApiModelProperty(value = "Product's name", required = true)
	private String name;
	@ApiModelProperty(value = "Product's category", required = true)
	private String category;
	@ApiModelProperty(value = "Product's price", required = true)
	private double price;
	@ApiModelProperty(value = "Product's stock", required = true)
	private int stock;

	/**
	 * Creates the product.
	 */
	public Product() {
	}

	/**
	 * This method returns the product's id.
	 * 
	 * @return The products id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method replaces the Product's id.
	 * 
	 * @param id
	 *            The id to be replaced
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * This method returns the product's name.
	 * 
	 * @return The products name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method replaces the Product's name.
	 * 
	 * @param name
	 *            The name to be replaced
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method returns the product's category.
	 * 
	 * @return The products category.
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * This method replaces the Product's category.
	 * 
	 * @param category
	 *            The category to be replaced
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * This method returns the product's price.
	 * 
	 * @return The products price.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * This method replaces the Product's price.
	 * 
	 * @param price
	 *            The price to be replaced
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * This method returns the product's stock.
	 * 
	 * @return The products stock.
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * This method replaces the Product's stock.
	 * 
	 * @param stock
	 *            The stock to be replaced
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof Product) && (((Product) o).getId() == this.id)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.id;
	}
}
