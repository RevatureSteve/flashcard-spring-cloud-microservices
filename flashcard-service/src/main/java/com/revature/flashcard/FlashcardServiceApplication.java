package com.revature.flashcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker 
@EnableEurekaClient
@SpringBootApplication
public class FlashcardServiceApplication {

	/*
	 * 2 Business Services connecting to Eureka
	 * 		and providing Health Checks to Eureka
	 * 		The health checks are indicating of more than a simple
	 * 		status code of 200. If a service goes down and wants to inform
	 * 		the other services it will send a message to Eureka and Eureka
	 * 		will take it out of the registry 
	 */
	public static void main(String[] args) {
		SpringApplication.run(FlashcardServiceApplication.class, args);
	}
}
