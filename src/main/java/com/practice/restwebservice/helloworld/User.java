package com.practice.restwebservice.helloworld;

public class User {

	int userId;
	String name;

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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}
	
}
