package services;

import java.util.ArrayList;

import entities.User;

public interface UserService {
	
	 public void addUser(User user);  
	 
	 public ArrayList<User> getUsers();
	 
	 public User getUser(int id);
	 
	 public void deleteUser(User user);
	 
	 public void updateUser(User user);
	 
}
