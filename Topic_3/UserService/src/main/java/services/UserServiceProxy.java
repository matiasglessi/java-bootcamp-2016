package services;

import java.util.ArrayList;

import entities.User;

public class UserServiceProxy implements UserService {
	
	private UserService userService;

	
	public UserServiceProxy(UserService userService) {
		this.userService = userService; 
	}

	public void addUser(User user) {
		userService.addUser(user);
	}

	public ArrayList<User> getUsers() {
		return userService.getUsers();
	}

	public void deleteUser(User user) {
		userService.deleteUser(user);	
	}

	public User getUser(int id) {
		return userService.getUser(id);
	}

	public void updateUser(User user) {
		userService.updateUser(user);
	}
	
}
