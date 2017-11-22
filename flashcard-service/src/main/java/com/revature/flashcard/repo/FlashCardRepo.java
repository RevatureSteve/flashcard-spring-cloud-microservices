package com.revature.flashcard.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.flashcard.bean.FlashCard;
/**
 * 11-22-2017
 * @author Steve_Revature
 *
 */
public interface FlashCardRepo extends JpaRepository<FlashCard, Integer>{

	/*
	 * 	Alternative Options
	 * 
	 *  CrudRepository
	 *  PagingAndSortingRepository
	 */
}
