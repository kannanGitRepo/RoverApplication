package com.rover.beans;

public class Environment {
	
	private int temperature;
	private int humidity;
	private boolean solarFlare;
	private boolean strom;
	private String terrainType;
	
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
	public void setSolarFlare(boolean solarFlare) {
		this.solarFlare = solarFlare;
	}
	public boolean isStrom() {
		return strom;
	}
	public void setStrom(boolean strom) {
		this.strom = strom;
	}
	public String getTerrainType() {
		return terrainType;
	}
	public void setTerrainType(String terrainType) {
		this.terrainType = terrainType;
	}
	@Override
	public String toString() {
		return "Environment [temperature=" + temperature + ", humidity=" + humidity + ", solarFlare=" + solarFlare
				+ ", strom=" + strom + ", terrainType=" + terrainType + "]";
	}
	
	

}
