package services;

import java.util.ArrayList;
import entities.User;
import entities.UserData;

public class UserWebService implements UserService {
	
	UserService implementation = new UserData();

	public void addUser(User user) {
		implementation.addUser(user);
		
	}

	public ArrayList<User> getUsers() {
		return implementation.getUsers();
	}

	public User getUser(int id) {
		return implementation.getUser(id);
	}

	public void deleteUser(User user) {
		implementation.deleteUser(user);
	}

	public void updateUser(User user) {
		implementation.updateUser(user);
	}  
}