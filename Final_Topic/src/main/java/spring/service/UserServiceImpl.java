package spring.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import spring.dao.UserDAO;
import spring.dao.UserDAOImpl;
import spring.model.User;

@Service
public class UserServiceImpl implements UserService {

	UserDAO userDao = new UserDAOImpl();

	public User isValidUser(String user, String pass) throws ClassNotFoundException, SQLException {
		return userDao.isValidUser(user, pass);
	}

	public User create(User user) throws ClassNotFoundException, SQLException {
		if (userDao.exists(user.getUsername()) == null) {
			userDao.create(user);
			return user;
		}
		return null;
	}

	public User update(User user) throws ClassNotFoundException, SQLException {
		if (userDao.exists(user.getUsername()) != null) {
			userDao.update(user);
			return user;
		}
		return null;
	}

	public User delete(User user) throws ClassNotFoundException, SQLException {
		if (userDao.exists(user.getUsername()) != null) {
			userDao.delete(user);
			return user;
		}
		return null;
	}

}
