package com.rover.beans;

import java.util.List;

public class AreaMap {

	private List<List<String>> areaMap;

	public List<List<String>> getAreaMap() {
		return areaMap;
	}

	public void setAreaMap(List<List<String>> areaMap) {
		this.areaMap = areaMap;
	}

	@Override
	public String toString() {
		return "AreaMap [areaMap=" + areaMap + "]";
	}
	
	
}
