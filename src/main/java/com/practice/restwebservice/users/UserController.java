package com.practice.restwebservice.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	UserServiceDAO userServiceDAO;

	@GetMapping(path = "/users")
	public List<User> retrieveUsers() {
		return userServiceDAO.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable String id){
		User user = userServiceDAO.findUser(Integer.parseInt(id));
		if (user == null) {
			 throw new UserNotFoundException("User not found for Id: "+id);
		}
		//Resource<User> res = new Resource<User>(user);
		return user;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {
		User savedUser = userServiceDAO.saveUser(user);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(savedUser.getUserId()).toUri();
		return ResponseEntity.created(loc).build();
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void DeleteUser(@PathVariable String id) {
		User user = userServiceDAO.findUser(Integer.parseInt(id));
		if (user == null) {
			 throw new UserNotFoundException("User not found for Id: "+id);
		} else {
			userServiceDAO.DeleteUser(Integer.parseInt(id));
		}
	}
}
