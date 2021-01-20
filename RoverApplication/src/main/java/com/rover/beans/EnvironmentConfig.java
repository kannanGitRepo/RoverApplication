package com.rover.beans;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvironmentConfig implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int temperature;
	private int humidity;
	private boolean solarFlare;
	private boolean strom;
	private List<List<String>> areaMap;
	
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public boolean isSolarFlare() {
		return solarFlare;
	}
	@JsonProperty("solar-flare")
	public void setSolarFlare(boolean solarFlare) {
		this.solarFlare = solarFlare;
	}
	public boolean isStrom() {
		return strom;
	}
	public void setStrom(boolean strom) {
		this.strom = strom;
	}
	public List<List<String>> getAreaMap() {
		return areaMap;
	}
	@JsonProperty("area-map")
	public void setAreaMap(List<List<String>> areaMap) {
		this.areaMap = areaMap;
	}
	@Override
	public String toString() {
		return "Environment [temperature=" + temperature + ", humidity=" + humidity + ", solarFlare=" + solarFlare
				+ ", strom=" + strom + ", areaMap=" + areaMap + "]";
	}
	
	
	
	
	
	
	
	
}
