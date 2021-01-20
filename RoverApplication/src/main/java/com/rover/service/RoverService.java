package com.rover.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rover.beans.AreaMap;
import com.rover.beans.Environment;
import com.rover.beans.EnvironmentConfig;
import com.rover.beans.InventoryItem;
import com.rover.beans.Location;
import com.rover.beans.Rover;
import com.rover.beans.RoverConfigure;
import com.rover.beans.TotalMovement;
import com.rover.configuration.AppConfig;
import com.rover.exception.RoverAppException;

@Service
public class RoverService {

	@Autowired
	AppConfig appConfig;

	public void createRover(EnvironmentConfig env, RoverConfigure roverConfig) {
		if (env != null) {
			Rover rover = appConfig.getRover();
			Environment environment = new Environment();
			environment.setHumidity(env.getHumidity());
			environment.setSolarFlare(env.isSolarFlare());
			environment.setStrom(env.isStrom());
			environment.setTemperature(env.getTemperature());
			rover.setEnvironment(environment);
		}

		if (roverConfig != null) {
			Rover rover = appConfig.getRover();
			rover.setBattery(roverConfig.getInitialBattery());
			rover.setInventryItem(roverConfig.getInventory());
			rover.setLocation(roverConfig.getDeployPoint());
			if (appConfig.getAreaMap().getAreaMap() != null) {
				rover.getEnvironment().setTerrainType(
						getTerrainType(appConfig.getAreaMap().getAreaMap(), roverConfig.getDeployPoint()));
			}
		}

	}

	public void printRover() {
		Rover rover = appConfig.getRover();
		System.out.println(rover);
	}

	public String getTerrainType(List<List<String>> areaMap, Location loc) {
		return areaMap.get(loc.getRow()).get(loc.getColumn());
	}

	public HttpStatus roverMove(Map<String, String> direction, Rover rover, AreaMap areaMap) throws RoverAppException {
		if (direction != null) {
			String direct = direction.get("direction");
			
			List<List<String>> map = areaMap.getAreaMap();
			Environment env = rover.getEnvironment();
			InventoryItem inventory = rover.getInventryItem().get(0);
			
			TotalMovement totalMove = appConfig.getTotalMovement();
			
			if(totalMove.getTotalMovement() == 10) {
				rover.setBattery(rover.getBattery()+10);
			}
			
			if (direct.equalsIgnoreCase("UP")) {
				if (getRow() - 1 < 0) {
					throw new RoverAppException("Can move only within mapped area");
				} else if (rover.getEnvironment().isStrom()) {
					throw new RoverAppException("Cannot move during a storm");
				} else if (rover.getBattery() <= 2) {
					throw new RoverAppException("Battery Low - Rover is Immobile");
				} else {
					rover.getLocation().setRow(getRow() - 1);
					rover.setBattery(rover.getBattery() - 1);
					setTerrainAndInventory(rover, map, env, inventory);					
					totalMove.setTotalMovement(totalMove.getTotalMovement()+1);
				}
			} else if (direct.equalsIgnoreCase("DOWN")) {
				if (getRow() + 1 >= map.size()) {
					throw new RoverAppException("Can move only within mapped area");
				} else if (rover.getEnvironment().isStrom()) {
					throw new RoverAppException("Cannot move during a storm");
				} else if (rover.getBattery() <= 2) {
					throw new RoverAppException("Battery Low - Rover is Immobile");
				} else {
					rover.getLocation().setRow(getRow() + 1);
					rover.setBattery(rover.getBattery() - 1);
					setTerrainAndInventory(rover, map, env, inventory);					
					totalMove.setTotalMovement(totalMove.getTotalMovement()+1);
				}
			} else if (direct.equalsIgnoreCase("LEFT")) {
				if (getColumn() - 1 < 0) {
					throw new RoverAppException("Can move only within mapped area");
				} else if (rover.getEnvironment().isStrom()) {
					throw new RoverAppException("Cannot move during a storm");
				} else if (rover.getBattery() <= 2) {
					throw new RoverAppException("Battery Low - Rover is Immobile");
				} else {
					rover.getLocation().setColumn(getColumn() - 1);
					rover.setBattery(rover.getBattery() - 1);
					setTerrainAndInventory(rover, map, env, inventory);					
					totalMove.setTotalMovement(totalMove.getTotalMovement()+1);

				}
			} else if (direct.equalsIgnoreCase("RIGHT")) {
				if (getColumn() + 1 >= map.get(getRow() - 1).size()) {
					throw new RoverAppException("Can move only within mapped area");
				} else if (rover.getEnvironment().isStrom()) {
					throw new RoverAppException("Cannot move during a storm");
				} else if (rover.getBattery() <= 2) {
					throw new RoverAppException("Battery Low - Rover is Immobile");
				} else {
					rover.getLocation().setColumn(getColumn() + 1);
					rover.setBattery(rover.getBattery() - 1);
					setTerrainAndInventory(rover, map, env, inventory);					
					totalMove.setTotalMovement(totalMove.getTotalMovement()+1);
				}
			}
			
			rover.setEnvironment(env);
			List<InventoryItem> inventoryList = new ArrayList<InventoryItem>();
			inventoryList.add(inventory);
			rover.setInventryItem(inventoryList);
		}

		return HttpStatus.OK;

	}
	
	public int getRow() {
		return appConfig.getRover().getLocation().getRow();
	}
	
	public int getColumn() {
		return appConfig.getRover().getLocation().getColumn();
	}

	private void setTerrainAndInventory(Rover rover, List<List<String>> map, Environment env, InventoryItem inventory) {
		env.setTerrainType(map.get(rover.getLocation().getRow()).get(rover.getLocation().getColumn()));
		if(env.getTerrainType().equalsIgnoreCase("water") || env.getTerrainType().equalsIgnoreCase("rock")) {
			if(inventory.getPriority() != 1) {
				if(inventory.getPriority() == 2 && inventory.getQuantity() < 2) {
					inventory.setQuantity(inventory.getQuantity()+1);
				}else if(inventory.getQuantity() < 3){
					inventory.setPriority(3);
					inventory.setQuantity(inventory.getQuantity()+1);
					inventory.setType("rock");
				}
				
			}
		}
	}

	public Rover stormAction(Map<String, Boolean> storm) {
		TotalMovement totalMove = appConfig.getTotalMovement();
		Rover rover = appConfig.getRover();
		InventoryItem inventory = rover.getInventryItem().get(0);
		if (storm != null) {
			rover.getEnvironment().setStrom(storm.get("storm"));
			if (inventory.getType().equalsIgnoreCase("storm-shield") && rover.getEnvironment().isStrom()) {
				if (inventory.getQuantity() != 0) {
					inventory.setQuantity(inventory.getQuantity() - 1);
				} else {
					totalMove.setDestroyed(true);
				}
			}
		}
		
		return rover;
	}

}