package com.revature.flashcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.flashcard.bean.FlashCard;

@RestController
public class FlashCardCtrl {

	@GetMapping("/")
	public String fc(){
		System.out.println("/ hello world -FlashCardCtrl");
		return "Hello MicroService FlashCard";
	}
	

}
