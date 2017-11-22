package com.revature.flashcard.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.flashcard.message.FcMessageSourceStep2andStep3;

/**
 * 11-22-2017
 * @author Steve_Revature
 *
 */
@RestController
public class MessageCtrlStep3 {

	/*
	 *  Step 3 - Event based messaging using Web
	 */
	@Autowired
	FcMessageSourceStep2andStep3 mysource;

	@RequestMapping(path = "/fc", method = RequestMethod.POST)
	public String publishMessage(@RequestBody String payload) {
		Random r = new Random();
		System.out.println(payload);
		
		mysource.fcMessagePlace1().send(
				MessageBuilder
				.withPayload(payload)
				.setHeader("speed", r.nextInt(8) * 10)
				.build());

		return "success";
	}

}
