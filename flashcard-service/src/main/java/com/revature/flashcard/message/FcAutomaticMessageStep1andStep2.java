package com.revature.flashcard.message;

import java.util.Random;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

import com.revature.flashcard.bean.FlashCard;

/**
 * 11-2017
 * @author Steve_Revature
 * 
 * Source.class is a default class (Step 1)
 * Will use FcMessageSourceStep2andStep3 will be used for Step 2 & 3
 */
@EnableBinding(Source.class)
public class FcAutomaticMessageStep1andStep2 {

	/*
	 *  Step 1 - automatically sending messages to rabbitmq
	 *  
	 *  the message-service needs to have:
	 *  spring.cloud.stream.bindings.output.destination=flashcardmessage1
	 *  &&
	 *   Basic Polling for one method - Step 1 uncommented
	 */
	//By Default will send message every 1 second
	@InboundChannelAdapter(channel=Source.OUTPUT)
	public String sendMessageExample(){
		return "{id:\"1\", question: \"testq-step1\", answer:\"testa-step1\"}";
	}
	
	/*
	 * Step 2 - update polling (automatic messaging)
	 * 	1. Uses FcMessageSource Interface
	 * 	2. Can Return MessageSource<Model>
	 * 	3. uncomment:
	 * 		spring.cloud.stream.bindings.FcMessageSource.destination=flashcardmessage1
	 * 		spring.cloud.stream.default.contentType=application/json
	 * 	4. in message-service uncomment Multiple methods polling & web
	 * 
	 * The setHeader() will randomly assign a "speed" value and that will decide which method
	 *  in the Message service will handle it.
	 */
//	@Bean
//	@InboundChannelAdapter(channel="flashcardmessage1", poller=@Poller(fixedDelay="2000"))
//	public MessageSource<FlashCard>  sendMessageExample(){
//		Random r = new Random();
//		FlashCard fc =  new FlashCard(1, "question1", "answer" + r.nextInt(10));
//
//		//Add header to route to different message-service methods
//		return () -> MessageBuilder.withPayload(fc).setHeader("speed",  r.nextInt(8)*10).build();
//	}
}
