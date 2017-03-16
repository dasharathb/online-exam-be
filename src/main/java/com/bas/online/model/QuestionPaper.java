package com.bas.online.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="questionPaper_dtl")
public class QuestionPaper {
	@Id
	private String id;
	private String duration;
	private List<Questions> questions;
	
	public QuestionPaper() {
		super();
	}

	public QuestionPaper(String id, String duration, List<Questions> questions) {
		super();
		this.id = id;
		this.duration = duration;
		this.questions = questions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "QuestionPaper [id=" + id + ", duration=" + duration + ", questions=" + questions + "]";
	}

			
}
