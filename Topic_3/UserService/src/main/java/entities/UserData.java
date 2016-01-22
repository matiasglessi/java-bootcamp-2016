package entities;

import java.util.ArrayList;
import java.util.Iterator;

import services.UserService;

public class UserData implements UserService {
	
	private ArrayList<User> users;
		
	public UserData(){
		this.users = new ArrayList<User>();
	}

	public void addUser(User user) {
		users.add(0, user);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public User getUser(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()){
			User userIt = iterator.next();
			if(userIt.getId()==id)
				return userIt;
		}
		return null;
	}

	public void deleteUser(User user) {
		users.remove(user);
	}

	public void updateUser(User user) {
		users.remove(user);
		users.add(user);
	}
}