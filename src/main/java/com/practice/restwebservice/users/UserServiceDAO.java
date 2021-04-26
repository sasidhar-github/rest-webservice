package com.practice.restwebservice.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserServiceDAO {
 static  List<User> list = new ArrayList<User>();
  int userCount = list.size();
  static {
	  list.add(new User(1, "Ranga"));
	  list.add(new User(5, "Mang"));
  }
  
  List<User> findAll(){
	  return list;
  }
  
  User findUser(int id) throws RuntimeException {
	    for(User user : findAll()) {
	    	if(user.getUserId()==id) {
	    		return user;
	    	}
	    }
	  return null;
  }
  
  User saveUser(User user) {
	  if(user != null) {
		  ++userCount;
		  user.setUserId(userCount);
	  }
	  list.add(user);
	  return user;
  }
  
  
  boolean DeleteUser(int id) {
	  if(list != null) {
		for(User user : list) {
			if(user.getUserId() == id) {
				list.remove(id);
				return true;
			}
		}
	  }
	  return false;

  }
  
}
