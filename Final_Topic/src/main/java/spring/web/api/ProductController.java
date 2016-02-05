package spring.web.api;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import spring.model.Product;
import spring.service.ProductService;

/**
 * This class represents a RESTful Web Service controller for the Product
 * entity.
 * 
 * @author Matias Glessi
 *
 */
@RestController
@Api(value = "products", description = "Products API", produces = "application/json")
public class ProductController {
	@Autowired
	ProductService productService;

	/**
	 * This method creates a new Product.
	 * 
	 * @param product
	 *            The product to be created
	 * @return The product created
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "/api/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create Product", notes = "Creates a new product.")
	@ApiResponses({ @ApiResponse(code = 201, message = "Success in the product creation."),
			@ApiResponse(code = 400, message = "The product could not be created.") })
	public ResponseEntity<Product> createProduct(@RequestBody Product product) throws ClassNotFoundException, SQLException {
		Product productCreated = productService.create(product);
		if (productCreated == null) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Product>(productCreated, HttpStatus.CREATED);
	}

	/**
	 * This method updates an existing product.
	 * 
	 * @param product
	 *            The product to be updated.
	 * @return The updated product.
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "/api/products", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update Product", notes = "Updates an existent product.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in the product update."),
			@ApiResponse(code = 406, message = "The product could not be updated.") })
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws ClassNotFoundException, SQLException {
		Product updatedProduct = productService.update(product);
		if (updatedProduct == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
	}

	/**
	 * This method deletes an existing product.
	 * 
	 * @param product
	 *            The product to be deleted.
	 * @return The deleted product
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "/api/products", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete Product", notes = "Deletes an existent product.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in the product elimination."),
			@ApiResponse(code = 404, message = "The product could not be deleted.") })
	public ResponseEntity<Product> deleteProduct(@RequestBody Product product) throws ClassNotFoundException, SQLException {
		Product deletedProduct = productService.delete(product);
		if (deletedProduct == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);
	}

	/**
	 * This method gets a list of products that match with the given name.
	 * 
	 * @param name
	 *            The name parameter for the search
	 * @return A list of products
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "api/products/findbyname/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find Product by name", notes = "Finds a list of products by name.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in the product search."),
			@ApiResponse(code = 404, message = "No products were found.") })
	public ResponseEntity<ArrayList<Product>> findByName(@PathVariable String name) throws ClassNotFoundException, SQLException {
		ArrayList<Product> productsFinded = productService.findByName(name);
		if (productsFinded == null) {
			return new ResponseEntity<ArrayList<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ArrayList<Product>>(productsFinded, HttpStatus.OK);

	}

	/**
	 * This method gets a list of products that match with the given category.
	 * 
	 * @param name
	 *            The category parameter for the search
	 * @return A list of products
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "api/products/findbycategory/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find Product by category", notes = "Finds a list of products by category.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in the product search."),
			@ApiResponse(code = 404, message = "No products were found.") })
	public ResponseEntity<ArrayList<Product>> findByCategory(@PathVariable String category) throws ClassNotFoundException, SQLException {
		ArrayList<Product> productsFinded = productService.findByCategory(category);
		if (productsFinded == null) {
			return new ResponseEntity<ArrayList<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ArrayList<Product>>(productsFinded, HttpStatus.OK);

	}
}
