package com.practice.restwebservice.helloworld;

public class HelloWorldBean {
	
	String message;
	int age;
	
	public HelloWorldBean(String message) {
		this.message = message;
	}
	
	public HelloWorldBean(String message,int age) {
		this.message = message;
		this.age = age;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + ", age=" + age + "]";
	}

	
	

}
