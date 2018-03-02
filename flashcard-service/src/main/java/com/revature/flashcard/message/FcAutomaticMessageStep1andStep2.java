//package com.revature.flashcard.message;
//
//import java.util.Random;
//
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.context.annotation.Bean;
//import org.springframework.integration.annotation.InboundChannelAdapter;
//import org.springframework.integration.annotation.Poller;
//import org.springframework.integration.core.MessageSource;
//import org.springframework.messaging.support.MessageBuilder;
//
//import com.revature.flashcard.bean.FlashCard;
//
///**
// * 11-2017
// * @author Steve_Revature
// * 
// * Source.class is a default class (Step 1)
// * Will use FcMessageSourceStep2andStep3 will be used for Step 2 & 3
// */
//@EnableBinding(Source.class)
//public class FcAutomaticMessageStep1andStep2 {
//
//	/*
//	 *  Step 1 - automatically sending messages to rabbitmq
//	 *  
//	 *  the message-service needs to have:
//	 *  spring.cloud.stream.bindings.output.destination=flashcardmessage1
//	 *  &&
//	 *   Basic Polling for one method - Step 1 uncommented
//	 */
//	//By Default will send message every 1 second
////	@InboundChannelAdapter(channel=Source.OUTPUT)
////	public String sendMessageExample(){
////		return "{id:\"1\", question: \"testq-step1\", answer:\"testa-step1\"}";
////	}
//
//}
