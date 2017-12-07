package com.revature.flashcard;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {

	int errorcode = 0;
	/*
	 * Example of a Health Check Payload to Eureka
	 * 	every time this Service sends a message to Eureka it increments
	 * 	its errorcode by 1. 
	 * When the errorcode is between 3 & 6 the service pretending to be down
	 * 		and tells Eureka  
	 */
	
	@Override
	public Health health() {
		
		System.out.println("health check performed, error code is " + errorcode);
		
		if(errorcode > 3 && errorcode < 6) {
			errorcode++;
			return Health.down().withDetail("Custom Error Code", errorcode).build();
		}
		else {

			errorcode++;
			return Health.up().build();
		}
	}
}