package com.revature.flashcard.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * 11-22-2017
 * @author Steve_Revature
 *
 */
@Entity
public class FlashCard {
	
	@Id
	@Column(name="FC_ID")
	private int id;
	
	@Column(name="FC_QUESTION")
	private String question;
	@Column(name="FC_ANSWER")
	private String answer;
	
	public FlashCard() {
	}

	public FlashCard(int id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "FlashCard [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}

}
