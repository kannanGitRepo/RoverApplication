package com.rover.beans;

public class Condition {

	private String type;
	private String property;
	private String value;
	private String Operator;
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getProperty() {
		return property;
	}


	public void setProperty(String property) {
		this.property = property;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getOperator() {
		return Operator;
	}


	public void setOperator(String operator) {
		Operator = operator;
	}


	@Override
	public String toString() {
		return "Condition [type=" + type + ", property=" + property + ", value=" + value + ", Operator=" + Operator
				+ "]";
	}
	
	
	
	
}
