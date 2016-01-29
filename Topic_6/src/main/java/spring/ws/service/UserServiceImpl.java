package spring.ws.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import spring.ws.model.User;


@Service
public class UserServiceImpl implements UserService {
	
	private static Long nextId;
    private static Map<Long, User> userMap;


	@Override
	public User create(User user){
		if (userMap == null) {
			userMap = new HashMap<Long, User>();
			nextId = new Long(1);
        }
	  	user.setId(nextId);
	  	if(!uniqueUsername(user.getNickname())){
	  		nextId += 1;
	  		userMap.put(user.getId(), user);
	        return user;	
	  	}
        return null;
	}

	@Override
	public User update(User user) {
		if (userMap == null) {
			userMap = new HashMap<Long, User>();
			nextId = new Long(1);
        }
        if (user.getId() != null) {
            User oldUser = userMap.get(user.getId());
            if (oldUser == null) {
                return null;
            }
            if(uniqueUsername(user.getNickname()))
            	user.setNickname(oldUser.getNickname());
        	userMap.remove(user.getId());
            userMap.put(user.getId(), user);
            return user;
        }
        return null;
	}
	
	
	public boolean uniqueUsername(String username){
		Iterator<Entry<Long, User>> entries = userMap.entrySet().iterator();
		while (entries.hasNext()) {
		    User userEntry = entries.next().getValue();
		    if(userEntry.getNickname().equals(username))
		    	return true;
		}
		return false;
	}


	@Override
	public boolean delete(User user) {
		 User deletedUser = userMap.remove(user.getId());
	     if (deletedUser == null) {
	         return false;
	     }
	     return true;
	}

	@Override
	public User findByName(String name) {
		Iterator<Entry<Long, User>> entries = userMap.entrySet().iterator();
		while (entries.hasNext()) {
		    User userEntry = entries.next().getValue();
		    if(userEntry.getName().equals(name))
		    	return userEntry;
		}
		return null;
	}

	@Override
	public User findByNickname(String nickname) {
		Iterator<Entry<Long, User>> entries = userMap.entrySet().iterator();
		while (entries.hasNext()) {
		    User userEntry = entries.next().getValue();
		    if(userEntry.getNickname().equals(nickname))
		    	return userEntry;
		}
		return null;
	}

	@Override
	public Collection<User> findAllUsers() {
		if (userMap == null)
			return null;
		return userMap.values();
	}
	
}
