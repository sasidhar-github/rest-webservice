package com.practice.restwebservice.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StaticFilteringBean {
	
	private String name;
	@JsonIgnore
	private String depName;
	
	public StaticFilteringBean(String name, String depName) {
		super();
		this.name = name;
		this.depName = depName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	

}
