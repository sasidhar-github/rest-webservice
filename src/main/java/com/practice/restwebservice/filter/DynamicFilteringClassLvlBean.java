package com.practice.restwebservice.filter;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("getDynamicClassLvlFilter")
public class DynamicFilteringClassLvlBean {

	private String name;
	private String depName;
	private String mngrName;

	public String getMngrName() {
		return mngrName;
	}

	public void setMngrName(String mngrName) {
		this.mngrName = mngrName;
	}

	public DynamicFilteringClassLvlBean(String name, String depName) {
		super();
		this.name = name;
		this.depName = depName;
	}

	public DynamicFilteringClassLvlBean(String name, String depName, String mngrName) {
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
