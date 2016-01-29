package spring.ws.web.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import spring.ws.model.User;
import spring.ws.service.UserService;

@RestController
@Api(value = "users", description = "Users API", produces = "application/json")
public class UserController {

	@Autowired
	private UserService userService;


	 @RequestMapping(value = "/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)   
 	 @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Successful return list of existents users."),
	            @ApiResponse(code = 404, message = "Not found any users.")
	 }) 	
	 public ResponseEntity<Collection<User>> getUsers() {
		Collection<User> users = userService.findAllUsers();
		if (users == null)
			return new ResponseEntity<Collection<User>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/users/findByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find user by name", notes = "Finds user serching by it's name.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful finding of an user by name."),
            @ApiResponse(code = 404, message = "Non existent user.")
    })
	public ResponseEntity<User> getUserByName(@RequestParam(value = "name", required = true) String name) {
		User userFinded = userService.findByName(name);
		if (userFinded == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(userFinded, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/users/findByNickname", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find user by nickname", notes = "Finds user serching by it's nickname.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful finding of an user by nickname."),
            @ApiResponse(code = 404, message = "Non existent user.")
    })
	public ResponseEntity<User> getUserByNickname(@RequestParam(value = "nickname", required = true) String nickname) {
		User userFinded = userService.findByNickname(nickname);
		if (userFinded == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(userFinded, HttpStatus.OK);
	}
	
		
    @RequestMapping(value = "/api/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create user", notes = "Creates a new user.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful create of an user."),
            @ApiResponse(code = 406, message = "Not acceptable user for creation.")
    })
    public ResponseEntity<User> createUser(@RequestBody User user) {
		User userCreated = userService.create(user);
		if (userCreated == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update user", notes = "Updates an existing user.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful update of an user."),
            @ApiResponse(code = 406, message = "Non existent user.")
    })
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User updatedUser = userService.update(user);
		if (updatedUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/users", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete user", notes = "Deletes an existing user.")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Successful delete of an user."),
            @ApiResponse(code = 404, message = "Non existent user.")
    })
	public ResponseEntity<User> deleteUser(@RequestBody User user) {
		boolean userDeletedStatus = userService.delete(user);
		if (!userDeletedStatus)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
