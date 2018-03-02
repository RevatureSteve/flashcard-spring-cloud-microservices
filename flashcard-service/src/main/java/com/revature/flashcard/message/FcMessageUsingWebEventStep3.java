package com.revature.flashcard.message;

import java.util.Random;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.revature.flashcard.bean.FlashCard;

/*
 *  Step 2/3 - needed for a component/instance of FcMessageSourceStep2andStep3 Interface
 *  
 *  	Can 
 */

@EnableBinding(FcMessageSourceStep2andStep3.class)
public class FcMessageUsingWebEventStep3 {

	/*
	 *  This class itself is need to make an instance of FcMessageSourceStep2andStep3
	 * 
	 */
	
	/*
	 * Step 2 - update polling (automatic messaging)
	 * 	1. Uses FcMessageSourceStep2andStep3 Interface
	 * 	2. Can Return MessageSource<Model>
	 * 	3. uncomment:
	 * 		spring.cloud.stream.bindings.FcMessageSource.destination=flashcardmessage1
	 * 		spring.cloud.stream.default.contentType=application/json
	 * 	4. in message-service uncomment Multiple methods polling & web
	 * 
	 * The setHeader() will randomly assign a "speed" value and that will decide which method
	 *  in the Message service will handle it.
	 */
	@Bean
//	@InboundChannelAdapter(channel="flashcardmessage1", poller=@Poller(fixedDelay="2000"))
	public MessageSource<FlashCard>  sendMessage1Example(){
		Random r = new Random();
		FlashCard fc =  new FlashCard(1, "question1", "answer" + r.nextInt(10));
		MessageSource<FlashCard> m = () -> MessageBuilder.withPayload(fc).setHeader("speed",  r.nextInt(8)*10).build();
		//Add header to route to different message-service methods
		return () -> MessageBuilder.withPayload(fc).setHeader("speed",  r.nextInt(8)*10).build();
		//now when the m.receive(); is called it will do MessageBuilder.withPayload(fc).setHeader("speed",  r.nextInt(8)*10).build();
	}
	
	@Bean
//	@InboundChannelAdapter(channel="flashcardmessage2", poller=@Poller(fixedDelay="2000"))
	public MessageSource<FlashCard>  sendMessage2Example(){
		Random r = new Random();
		FlashCard fc =  new FlashCard(1, "question1", "answer" + r.nextInt(10));

		//Add header to route to different message-service methods
		return () -> MessageBuilder.withPayload(fc).setHeader("speed",  r.nextInt(8)*10).build();
	}
}
