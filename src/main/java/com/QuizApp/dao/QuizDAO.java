package com.QuizApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QuizApp.Modal.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz,Integer>{

}
