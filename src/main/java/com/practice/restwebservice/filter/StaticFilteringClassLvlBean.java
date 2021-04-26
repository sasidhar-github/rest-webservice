package com.practice.restwebservice.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"name","depName"})
public class StaticFilteringClassLvlBean {

	private String name;
	private String depName;
	private String mngrName;

	public String getMngrName() {
		return mngrName;
	}

	public void setMngrName(String mngrName) {
		this.mngrName = mngrName;
	}

	public StaticFilteringClassLvlBean(String name, String depName) {
		super();
		this.name = name;
		this.depName = depName;
	}

	public StaticFilteringClassLvlBean(String name, String depName, String mngrName) {
		super();
		this.name = name;
		this.depName = depName;
		this.mngrName = mngrName;
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
