package com.rover.beans;

import java.util.List;

public class State {

	private String name;
	private List<String> allowedActions;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getAllowedActions() {
		return allowedActions;
	}
	public void setAllowedActions(List<String> allowedActions) {
		this.allowedActions = allowedActions;
	}
	@Override
	public String toString() {
		return "State [name=" + name + ", allowedActions=" + allowedActions + "]";
	}
	
	
	
}
