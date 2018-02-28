package com.revature.studyset;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class StudySetCtrl {

	@GetMapping("/studyset")
	public ResponseEntity<HttpStatus> getStudySet(){
		System.out.println("good");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
