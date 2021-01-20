package com.rover.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.rover.beans.AreaMap;
import com.rover.beans.Rover;
import com.rover.beans.TotalMovement;

@Configuration
public class AppConfig {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Rover getRover() {

		return new Rover();

	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public AreaMap getAreaMap() {
		return new AreaMap();
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public TotalMovement getTotalMovement() {
		return new TotalMovement();
	}
}
