package com.rover.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoverConfigure {

	private List<Scenario> scenarios;
	private List<State> states;
	private Location deployPoint;
	private int initialBattery;
	private List<InventoryItem> inventory;
	
	public List<Scenario> getScenarios() {
		return scenarios;
	}
	public void setScenarios(List<Scenario> scenarios) {
		this.scenarios = scenarios;
	}
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}
	public Location getDeployPoint() {
		return deployPoint;
	}
	@JsonProperty("deploy-point")
	public void setDeployPoint(Location deployPoint) {
		this.deployPoint = deployPoint;
	}
	public int getInitialBattery() {
		return initialBattery;
	}
	@JsonProperty("initial-battery")
	public void setInitialBattery(int initialBattery) {
		this.initialBattery = initialBattery;
	}
	public List<InventoryItem> getInventory() {
		return inventory;
	}
	public void setInventory(List<InventoryItem> inventory) {
		this.inventory = inventory;
	}
	@Override
	public String toString() {
		return "RoverConfigure [scenarios=" + scenarios + ", states=" + states + ", deployPoint=" + deployPoint
				+ ", initialBattery=" + initialBattery + ", inventory=" + inventory + "]";
	}
	
	
	
}
