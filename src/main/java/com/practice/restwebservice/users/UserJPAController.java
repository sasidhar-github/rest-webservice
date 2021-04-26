package com.practice.restwebservice.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJPAController {

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;

	@GetMapping(path = "/users/jpa")
	public List<User> retrieveUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path = "/users/jpa/{id}")
	public User getUser(@PathVariable String id){
		Optional<User> user = userRepository.findById(Integer.parseInt(id));
		if (!user.isPresent()) {
			 throw new UserNotFoundException("User not found for Id: "+id);
		}
		//Resource<User> res = new Resource<User>(user);
		return user.get();
	}

	@PostMapping(path = "/users/jpa")
	public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(savedUser.getUserId()).toUri();
		return ResponseEntity.created(loc).build();
	}
	
	@DeleteMapping(path = "/users/jpa/{id}")
	public void DeleteUser(@PathVariable String id) {
		userRepository.deleteById(Integer.parseInt(id));	
	}
	
	@GetMapping(path = "/users/jpa/{id}/posts")
	public List<Post> getPost(@PathVariable String id){
		Optional<User> user = userRepository.findById(Integer.parseInt(id));
		if (!user.isPresent()) {
			 throw new UserNotFoundException("User not found for Id: "+id);
		}
		return user.get().getPosts();
	}
	
	@PostMapping(path = "/users/jpa/{id}/post")
	public ResponseEntity<User> CreatePost(@PathVariable String id,@RequestBody Post post) {
		Optional<User> user = userRepository.findById(Integer.parseInt(id));
		if (!user.isPresent()) {
			 throw new UserNotFoundException("User not found for Id: "+id);
		}
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(savedPost.getPostId()).toUri();
		return ResponseEntity.created(loc).build();
	}
	
}
