package com.revature.flashcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * 11-22-2017
 * @author Steve_Revature
 *	
 *	Spring Cloud Stream with Rabbitmq Messaging Service Application Example
 *
 *		2 Projects
 *			-flashcard business microservice
 *			-messaging service
 */
@SpringBootApplication
public class FlashcardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashcardServiceApplication.class, args);
	}
}
