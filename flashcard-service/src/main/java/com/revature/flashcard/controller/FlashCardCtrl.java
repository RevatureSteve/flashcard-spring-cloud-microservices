package com.revature.flashcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.flashcard.bean.FlashCard;
import com.revature.flashcard.service.FlashCardService;

/**
 *  11-22-2017
 * @author Steve_Revature
 *	Spring Boot Rest Controller Example with Spring Data
 */

@RestController
public class FlashCardCtrl {
	/*
	 * 	Basic Rest Controller
	 * 		3 Basic Endpoints
	 * 			-/ returns String
	 * 			-/fc/{id} returns a FlashCard based on an id provide in the URL 
	 * 			-/fc returns all FlashCards
	 * 		
	 * 		3 Better Endpoints 
	 * 			-/
	 */
	@Autowired
	private FlashCardService fcService;
	
	//Basic RequestMapping for an HttpRequest-GET
	@GetMapping("/")
	public String fc(){
		System.out.println("/ hello world -FlashCardCtrl");
		return "Hello FlashCard Spring Boot";
	}
	
	@GetMapping("/fc/{id}")
	public FlashCard getFc(@PathVariable String id){
		System.out.println("Request to FlashCardCtrl /fc/ " + id);

//		What happends if the user requests a FlashCard with an ID that is not found in the DB?
		FlashCard fc = fcService.getFlashCardById(Integer.parseInt(id)); 
		return fc;
	}
	
	@GetMapping("/fc")
	public List<FlashCard> getAllFlashCards(){
		System.out.println("Request to FlashCardCtrl /fc -all FCs");
		List<FlashCard> fcList = fcService.getAll();
		return fcList;
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<FlashCard> createFc(@RequestBody FlashCard fc){
		System.out.println("Request to FlashCardCtrl /create " + fc);
		fcService.createFc(fc);
		return new ResponseEntity<FlashCard>(fc, HttpStatus.CREATED);
	}
	
}
 