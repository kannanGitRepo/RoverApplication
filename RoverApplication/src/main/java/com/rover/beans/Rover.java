package com.rover.beans;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;


public class Rover implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private List<InventoryItem> inventryItem;
	private Location location;
	private int battery;
	private Environment environment;
	
	public List<InventoryItem> getInventryItem() {
		return inventryItem;
	}
	public void setInventryItem(List<InventoryItem> inventryItem) {
		this.inventryItem = inventryItem;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	public Environment getEnvironment() {
		return environment;
	}
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	@Override
	public String toString() {
		return "Rover [inventryItem=" + inventryItem + ", location=" + location + ", battery=" + battery
				+ ", environment=" + environment + "]";
	}
	
	
}
 