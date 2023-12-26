package com.QuizApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.QuizApp.Modal.Question;
import com.QuizApp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestion")
	public ResponseEntity<List<Question>> getAllQuestion() {
		return questionService.getAllQuestions();
	}
	
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String category) {
		return questionService.getAllQuestionsByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> AddQuestion(@RequestBody Question ques) {
		return questionService.addQuestion(ques);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> DeleteQuestion(@PathVariable int id) {
		return questionService.deleteQuestionById(id);
	}
	
	@PutMapping("update")
	public ResponseEntity<String> UpdateQuestion(@RequestBody Question ques) {
		return questionService.updateQuestion(ques);
	}
	
	
}
