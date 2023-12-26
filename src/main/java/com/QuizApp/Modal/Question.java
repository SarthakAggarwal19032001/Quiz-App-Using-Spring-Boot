package com.QuizApp.Modal;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Question {
	
	@Id
	private int id;
	private String category;
	private String difficultlevel;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String questiontitle;
	private String rightanswer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDifficultLevel() {
		return difficultlevel;
	}
	public void setDifficultLevel(String difficultyLevel) {
		this.difficultlevel = difficultyLevel;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getQuestionTitle() {
		return questiontitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questiontitle = questionTitle;
	}
	public String getRightAnswer() {
		return rightanswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightanswer = rightAnswer;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", category=" + category + ", difficultyLevel=" + difficultlevel + ", option1="
				+ option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
				+ ", questionTitle=" + questiontitle + ", rightAnswer=" + rightanswer + "]";
	}
	
}
