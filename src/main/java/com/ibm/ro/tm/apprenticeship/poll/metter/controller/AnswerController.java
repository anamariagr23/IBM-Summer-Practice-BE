/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.AnswerService;

/**
 * @author vlads
 *
 */
@RestController
@RequestMapping("/answers")
public class AnswerController {

	private AnswerService answerService;
	
	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Answer>> getAllAnswers(){
		List<Answer> answers = answerService.findAllAnswers();
		return new ResponseEntity<>(answers, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Answer> deleteAnswer(@PathVariable Long id){
		answerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Answer> addAnswer(@RequestBody Answer answer){
		Answer newAnswer = answerService.add(answer);
		return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer){
		Answer updateAnswer = answerService.update(answer);
		return new ResponseEntity<>(updateAnswer, HttpStatus.OK);
	}
//	private final AnswerService answerService;
//

//	
//	/**
//	 * @return the answerService
//	 */
//	public AnswerService getAnswerService() {
//		return answerService;
//	}
//	
//	@GetMapping("/all")
//	public ResponseEntity<List<Answer>> getAllAnswers(){
//		List<Answer> answers = answerService.findAllAnswers();
//		return new ResponseEntity<>(answers, HttpStatus.OK);
//	}
//	
//	@GetMapping("/find/{id}")
//	public ResponseEntity<Answer> getAnswerById(@PathVariable("id") Long id){
//		Answer answer = answerService.findById(id);
//		return new ResponseEntity<>(answer, HttpStatus.OK);
//	}
//	
//	@PostMapping("/add")
//	public ResponseEntity<Answer> addAnswer(@RequestBody Answer answer){
//		Answer newAnswer = answerService.addAnswer(answer);
//		return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
//	}
//	
//	@PutMapping("/update")
//	public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer){
//		Answer updateAnswer = answerService.updateAnswer(answer);
//		return new ResponseEntity<>(updateAnswer, HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<Answer> deleteAnswer(@PathVariable Long id){
//		answerService.deleteAnswer(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
	
}
