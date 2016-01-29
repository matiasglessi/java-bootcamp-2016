package spring.ws.service;

import java.util.Collection;

import spring.ws.model.User;

public interface UserService {
	
	public User create(User user);
	
	public User update(User user);
	
	public boolean delete(User user);
	
	public User findByName(String name);
	
	public User findByNickname(String nickname);
	
	public Collection<User> findAllUsers();
}
