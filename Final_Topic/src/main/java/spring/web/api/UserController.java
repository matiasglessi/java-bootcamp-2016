package spring.web.api;

import java.sql.SQLException;
import java.util.HashMap;

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
import spring.model.Cart;
import spring.model.Product;
import spring.model.User;
import spring.service.CartService;
import spring.service.UserService;

/**
 * This class represents a RESTful Web Service controller for the User entity.
 * 
 * @author Matias Glessi
 *
 */
@RestController
@Api(value = "users", description = "Users API", produces = "application/json")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;

	User userlogged;
	Cart cartlogged;

	/**
	 * This method creates a new User.
	 * 
	 * @param user
	 *            The user to be created
	 * @return The user created
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "/api/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create User", notes = "Creates a new user.")
	@ApiResponses({ @ApiResponse(code = 201, message = "Success in the user creation."),
			@ApiResponse(code = 400, message = "The user could not be created.") })
	public ResponseEntity<User> createUser(@RequestBody User user) throws ClassNotFoundException, SQLException {
		User userCreated = userService.create(user);
		if (userCreated == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
	}

	/**
	 * This method updates an existing user.
	 * 
	 * @param user
	 *            The user to be updated.
	 * @return The updated user.
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "/api/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update User", notes = "Updates an existing user.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in the user update."),
			@ApiResponse(code = 406, message = "The user could not be updated.") })
	public ResponseEntity<User> updateUser(@RequestBody User user) throws ClassNotFoundException, SQLException {
		User updatedUser = userService.update(user);
		if (updatedUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}

	/**
	 * This method deletes an existing user.
	 * 
	 * @param user
	 *            The user to be deleted.
	 * @return The deleted USER
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "/api/users", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete User", notes = "Deletes an existing user.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in the user elimination."),
			@ApiResponse(code = 404, message = "The user could not be deleted.") })
	public ResponseEntity<User> deleteUser(@RequestBody User user) throws ClassNotFoundException, SQLException {
		User deletedUser = userService.delete(user);
		if (deletedUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(deletedUser, HttpStatus.OK);
	}

	/**
	 * This method logs the user in the system, by validating it's username and
	 * password.
	 * 
	 * @param username
	 *            The user's username
	 * @param password
	 *            The user's password
	 * @return The logged in user
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "api/users/login/{username}/{password}", method = RequestMethod.GET)
	@ApiOperation(value = "Login User", notes = "Logs in the user.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in the user login."),
			@ApiResponse(code = 404, message = "The user does not exists."),
			@ApiResponse(code = 400, message = "Could not log in. Another user logged.") })
	public ResponseEntity<User> login(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password)
			throws ClassNotFoundException, SQLException {
		if (userlogged == null) {
			userlogged = userService.isValidUser(username, password);
			cartlogged = cartService.getSavedCart(username);
			if (userlogged == null) {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<User>(userlogged, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method logs the user out of the system.
	 * 
	 * @return The user logged out
	 */

	@RequestMapping(value = "api/users/logout", method = RequestMethod.GET)
	@ApiOperation(value = "Logout User", notes = "Logs out the user.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in the user logout.") })
	public ResponseEntity<User> logout() {
		userlogged = null;
		return new ResponseEntity<User>(userlogged, HttpStatus.OK);
	}

	/**
	 * This methods saves the current state of the User's cart.
	 * 
	 * @return The cart's user.
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "api/users/saveCart", method = RequestMethod.GET)
	@ApiOperation(value = "Save Cart", notes = "Saves the status of the user's cart.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in saving the cart."),
			@ApiResponse(code = 400, message = "No user logged in.") })
	public ResponseEntity<User> saveCart() throws ClassNotFoundException, SQLException {
		if (userlogged == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		} else {
			cartService.saveCart(userlogged.getUsername(), cartlogged);
			return new ResponseEntity<User>(HttpStatus.OK);
		}
	}

	/**
	 * This methods buy all the products from the current cart.
	 * 
	 * @return The cart's user.
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "api/users/buyProducts", method = RequestMethod.GET)
	@ApiOperation(value = "Buy Products", notes = "Buys the content of the user's cart.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in buying the cart's products."),
			@ApiResponse(code = 406, message = "Insufficient sotck to complete the request."),
			@ApiResponse(code = 400, message = "No user logged in.") })
	public ResponseEntity<User> buyProducts() throws ClassNotFoundException, SQLException {
		if (userlogged == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		} else {
			if (cartService.buyProducts(cartlogged, userlogged.getUsername())) {
				return new ResponseEntity<User>(HttpStatus.OK);
			} else {
				return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
	}

	/**
	 * This method add a new Product to the User's cart.
	 * 
	 * @param product
	 *            The product to be added
	 * @param quantity
	 *            The quantity of the product
	 * @return The cart's user.
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "/api/users/addProduct/{quantity}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add Product", notes = "Adds a product to the user's cart.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in adding the product."),
			@ApiResponse(code = 406, message = "No user logged in.") })
	public ResponseEntity<User> addProduct(@RequestBody Product product, @PathVariable(value = "quantity") int quantity)
			throws ClassNotFoundException, SQLException {
		if (userlogged == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		} else {
			cartService.addProduct(cartlogged, product, quantity);
			return new ResponseEntity<User>(HttpStatus.OK);
		}
	}

	/**
	 * This method updates an existing Product to the User's cart.
	 * 
	 * @param product
	 *            The product to be updated
	 * @param quantity
	 *            The quantity of the product
	 * @return The cart's user.
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "/api/users/updateProduct/{quantity}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update Product", notes = "Updates an existing product in the user's cart.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success in updating the product."),
			@ApiResponse(code = 406, message = "No user logged in.") })
	public ResponseEntity<User> updateProduct(@RequestBody Product product, @PathVariable(value = "quantity") int quantity)
			throws ClassNotFoundException, SQLException {
		if (userlogged == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		} else {
			cartService.updateProduct(cartlogged, product, quantity);
			return new ResponseEntity<User>(HttpStatus.OK);
		}
	}

	/**
	 * This method deletes an existing Product from the User's cart.
	 * 
	 * @param product
	 *            The product to be deleted
	 * @param quantity
	 *            The quantity of the product
	 * @return The cart's user.
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "/api/users/deleteProduct", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete Product", notes = "Deletes an existing product in the user's cart.")
	@ApiResponses({ @ApiResponse(code = 201, message = "Success in deleting the product."),
			@ApiResponse(code = 200, message = "No user logged in.") })
	public ResponseEntity<User> deleteProduct(@RequestBody Product product) throws ClassNotFoundException, SQLException {
		if (userlogged == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		} else {
			cartService.deleteProduct(cartlogged, product);
			return new ResponseEntity<User>(HttpStatus.OK);
		}
	}

	/**
	 * This method returns all the existent products in the user's cart
	 * 
	 * @return A list of Products
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 */
	@RequestMapping(value = "/api/users/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful return list of existents product."),
			@ApiResponse(code = 404, message = "No user logged in.") })
	public ResponseEntity<HashMap<Product, Integer>> getProducts() throws ClassNotFoundException, SQLException {
		if (userlogged == null) {
			return new ResponseEntity<HashMap<Product, Integer>>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<HashMap<Product, Integer>>(cartlogged.getProducts(), HttpStatus.OK);
		}
	}
}
