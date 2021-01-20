package com.rover.beans;

import java.util.List;

public class Scenario {

	private String name;
	private List<Condition> conditions;
	private List<RoverAction> rover;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Condition> getConditions() {
		return conditions;
	}
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	public List<RoverAction> getRover() {
		return rover;
	}
	public void setRover(List<RoverAction> rover) {
		this.rover = rover;
	}
	@Override
	public String toString() {
		return "Scenario [name=" + name + ", conditions=" + conditions + ", rover=" + rover + "]";
	} 
	
	
}
