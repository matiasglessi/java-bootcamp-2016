package services;

import java.util.ArrayList;

import entities.User;

public class UserServiceWebServiceClient implements UserService {
	
	UserService webService;
	
	public UserServiceWebServiceClient(){
		// webService = code to get the reference to ShoppingCartService from the webservice call
	}

	public void addUser(User user) {
		webService.addUser(user);
		
	}

	public ArrayList<User> getUsers() {
		return webService.getUsers();
	}

	public User getUser(int id) {
		return webService.getUser(id);
	}

	public void deleteUser(User user) {
		webService.deleteUser(user);
	}

	public void updateUser(User user) {
		webService.updateUser(user);	
	}
}