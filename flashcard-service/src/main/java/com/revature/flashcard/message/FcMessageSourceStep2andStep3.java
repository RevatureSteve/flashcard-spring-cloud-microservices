package com.revature.flashcard.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/*
 * Map multiple outputs to Source
 */
public interface FcMessageSourceStep2andStep3 {

	@Output("flashcardmessage1")
	MessageChannel fcMessagePlace1();
	
	
	@Output("flashcardmessage2")
	MessageChannel fcMessagePlace2();
}
