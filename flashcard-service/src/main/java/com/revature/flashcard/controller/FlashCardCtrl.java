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
	
	/*
	 * 	Using another Microservice using RestTemplate
	 */
	@LoadBalanced
	@Bean
	public RestTemplate buildRestTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getFc")
	public FlashCard getFc(){
		System.out.println("Request to FlashCardCtrl /getFc");
		String url = "http://flashcard-service2/fc";
		FlashCard fc = restTemplate.getForObject(url, FlashCard.class);
		System.out.println(fc + " from flashcard-service2");
		return fc;
	}
}
