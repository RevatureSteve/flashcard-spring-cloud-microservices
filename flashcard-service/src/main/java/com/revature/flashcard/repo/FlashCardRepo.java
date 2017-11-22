package com.revature.flashcard.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.flashcard.bean.FlashCard;

public interface FlashCardRepo extends JpaRepository<FlashCard, Integer>{

	/*
	 * 	Alternative Options
	 * 
	 *  CrudRepository
	 *  PagingAndSortingRepository
	 */
}
