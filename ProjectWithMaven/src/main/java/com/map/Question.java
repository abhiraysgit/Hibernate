package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name = "question_id")
	private int questionID;
	private String question;
	@OneToOne
	private Answer answer;

	public Question(int questionID, String question, Answer answer) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.answer = answer;
	}

	public int getQuestionID() {
		return questionID;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
