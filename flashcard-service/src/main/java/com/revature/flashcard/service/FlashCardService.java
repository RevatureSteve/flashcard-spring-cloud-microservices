package com.revature.flashcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.flashcard.bean.FlashCard;
import com.revature.flashcard.repo.FlashCardRepo;
/**
 * 11-22-2017
 * @author Steve_Revature
 *
 */
@Service
public class FlashCardService {

	@Autowired
	FlashCardRepo fcRepo;
	
	public FlashCard getFlashCardById(int id){
		System.err.println("FlashCard Serivce -getFlashCardById " + id);
		return fcRepo.findOne(id); 
	}
	
	public List<FlashCard> getAll(){
		System.err.println("FlashCard Serivce -getAll ");
		return fcRepo.findAll();
	}
	
	public void createFc(FlashCard fc){
		System.err.println("FlashCard Serivce -createFc ");
		fcRepo.save(fc);
	}
}
