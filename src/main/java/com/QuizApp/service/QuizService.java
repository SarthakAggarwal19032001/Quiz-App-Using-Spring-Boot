package com.QuizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.QuizApp.Modal.Question;
import com.QuizApp.Modal.QuestionWrapper;
import com.QuizApp.Modal.Quiz;
import com.QuizApp.Modal.Response;
import com.QuizApp.dao.QuestionDAO;
import com.QuizApp.dao.QuizDAO;

@Service
public class QuizService {
	
	@Autowired
	QuizDAO quizDao;
	@Autowired
	QuestionDAO questionDao;
	
	
	public ResponseEntity<String> CreateQuiz(String category, int numQ, String title){
		
		Quiz quiz=new Quiz();
		
		quiz.setTitle(title);
		
		List<Question>questions=questionDao.findRandomQuestionsByCategory(category,numQ);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}


	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<Quiz> quiz=quizDao.findById(id);
		List<Question>question=quiz.get().getQuestions();
		List<QuestionWrapper>questionsForUser=new ArrayList<>();
		for(Question q:question) {
			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}


	public ResponseEntity<Integer> getResult(int id, List<Response> responses) {
		Optional<Quiz> quiz=quizDao.findById(id);
		List<Question>questions=quiz.get().getQuestions();
		int result=0;
		for(int i=0;i<questions.size();i++) {
			if(responses.get(i).getResponse().equals(questions.get(i).getRightAnswer())) {
				result++;
			}
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
}
