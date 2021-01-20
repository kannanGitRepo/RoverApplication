package com.rover.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rover.beans.EnvironmentConfig;
import com.rover.beans.InventoryItem;
import com.rover.beans.Rover;
import com.rover.configuration.AppConfig;
import com.rover.service.RoverService;

@RestController
@RequestMapping("/api/environment")
public class EnvironmentController {

	@Autowired
	RoverService roverService;
	
	@Autowired
	AppConfig appConfig;
	
	@PostMapping(value="/configure")
	public EnvironmentConfig createEnv(@RequestBody EnvironmentConfig env) {
		roverService.createRover(env,null);
		appConfig.getAreaMap().setAreaMap(env.getAreaMap());
		roverService.printRover();
		return env;
	}
	
	@RequestMapping(value="/", method = RequestMethod.PATCH)
	public Rover patchingStorm(@RequestBody Map<String,Boolean> storm) {
		return roverService.stormAction(storm);		
	}
	
	
	
}
