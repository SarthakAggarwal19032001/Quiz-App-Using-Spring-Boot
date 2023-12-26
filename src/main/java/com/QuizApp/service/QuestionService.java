package com.QuizApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.QuizApp.Modal.Question;
import com.QuizApp.dao.QuestionDAO;

@Service
public class QuestionService {
	@Autowired
	QuestionDAO questiondao;
	
	public ResponseEntity<List<Question>>getAllQuestions(){
		try {
			return new ResponseEntity<>(questiondao.findAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	

	public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<String> addQuestion(Question ques) {
		try {
			questiondao.save(ques);
			return new ResponseEntity<>("OK, 1 rows affected",HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Failed",HttpStatus.NOT_MODIFIED);
	}

	public ResponseEntity<String> deleteQuestionById(int id) {
		try {
			questiondao.deleteById(id);
			return new ResponseEntity<>("OK, 1 rows affected",HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed",HttpStatus.NOT_MODIFIED);
	}
	
	public ResponseEntity<String> updateQuestion(Question ques) {
		try {
			questiondao.save(ques);
			return new ResponseEntity<>("OK, 1 rows affected",HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Failed",HttpStatus.NOT_MODIFIED);
	}
}
