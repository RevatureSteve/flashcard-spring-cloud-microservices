package com.revature.flashcard.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
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
@EnableBinding(Sink.class)
@SpringBootApplication
public class FlashcardMessageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashcardMessageServiceApplication.class, args);
	}
//-------------------------------------------------------------------------------
	/*
	 *  Basic Polling for one method - Step 1
	 */
//	@StreamListener(Sink.INPUT)
//	public void log(String msg){
//		System.out.println(msg);
//	}
	
//-------------------------------------------------------------------------------
	/*
	 *  Multiple methods polling & web - Step 2 & 3
	 */
	@StreamListener(target=Sink.INPUT, condition="headers['speed'] > 40")
	public void logfast(String msg) {
		System.out.println("fast = " + msg);
//		return msg;
	}
	
	@StreamListener(target=Sink.INPUT, condition="headers['speed'] <= 40")
	public void logslow(String msg) {
		System.out.println("slow = " + msg);
		//return msg;
	}
	

}
