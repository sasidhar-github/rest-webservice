package com.practice.restwebservice.users;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "All details about the User details")
@Entity
public class User {

	@Id
	@GeneratedValue
	int userId;
	@Size(min = 2,message = "Name must be 2 digits minimum")
	String name;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	public User() {
	}

	public User(int userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}
	
}
