package services;

import java.util.ArrayList;

import entities.User;

public class UserServiceJmsClient implements UserService {

	UserService jmsObject;
	
	public UserServiceJmsClient() {
		//jmsObject = code to get the reference to ShoppingCart Service from the jms call  
	}

	public void addUser(User user) {
		jmsObject.addUser(user);
	}

	public ArrayList<User> getUsers() {
		return jmsObject.getUsers();
	}

	public User getUser(int id) {
		return jmsObject.getUser(id);
	}

	public void deleteUser(User user) {
		jmsObject.deleteUser(user);
	}

	public void updateUser(User user) {
		jmsObject.updateUser(user);
	}
}