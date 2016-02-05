package spring.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class represents an actual User.
 * 
 * @author Matias Glessi
 *
 */
@ApiModel(value = "User entity", description = "Complete data of an entity User")
public class User {

	@ApiModelProperty(value = "User's first name", required = true)
	private String first_name;
	@ApiModelProperty(value = "User's last name", required = true)
	private String last_name;
	@ApiModelProperty(value = "User's username", required = true)
	private String username;
	@ApiModelProperty(value = "User's password", required = true)
	private String password;

	/**
	 * Creates the user.
	 */
	public User() {
	}

	/**
	 * This method returns the users's first name.
	 * 
	 * @return The users's first name.
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * This method replaces the User's first name.
	 * 
	 * @param first_name
	 *            The name to be replaced
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * This method returns the users's last name.
	 * 
	 * @return The users's last name.
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * This method replaces the User's last name.
	 * 
	 * @param last_name
	 *            The name to be replaced
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * This method returns the users's username.
	 * 
	 * @return The users's username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method replaces the User's username.
	 * 
	 * @param username
	 *            The username to be replaced
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * This method returns the users's password.
	 * 
	 * @return The users's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method replaces the User's password.
	 * 
	 * @param password
	 *            The password to be replaced
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
