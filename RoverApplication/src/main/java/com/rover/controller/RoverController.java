package com.rover.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rover.beans.Rover;
import com.rover.beans.RoverConfigure;
import com.rover.beans.TotalMovement;
import com.rover.configuration.AppConfig;
import com.rover.service.RoverService;

@RestController
@RequestMapping("/api/rover")
public class RoverController {
	
	@Autowired
	RoverService roverService;
	
	@Autowired
	AppConfig appConfig;
	
	
	@PostMapping("/configure")
	public RoverConfigure configRover(@RequestBody RoverConfigure roverConfig) {
		TotalMovement totalMove = appConfig.getTotalMovement();

		if(!totalMove.isDestroyed()){
			roverService.createRover(null, roverConfig);
			roverService.printRover();
			return roverConfig;
		}else {
			return null;
		}
			
	}
	
	@GetMapping("/status")
	public Rover getStatus() {
		TotalMovement totalMove = appConfig.getTotalMovement();

		if(!totalMove.isDestroyed()){
			return appConfig.getRover();
		}else {
			return null;
		}
	}
	
	@PostMapping("/move")
	public HttpStatus move(@RequestBody Map<String,String> direction) {
		TotalMovement totalMove = appConfig.getTotalMovement();

		if(!totalMove.isDestroyed()){
			return roverService.roverMove(direction,appConfig.getRover(),appConfig.getAreaMap());	
		}else {
			return null;
		}
	}

}
