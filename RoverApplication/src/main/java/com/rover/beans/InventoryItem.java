package com.rover.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryItem {
	
	private String type;
	private int quantity;
	private int priority;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "InventoryItem [type=" + type + ", quantity=" + quantity + ", priority=" + priority + "]";
	}
	
	
	

}
