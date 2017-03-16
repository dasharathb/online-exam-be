package com.bas.online.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="exam_status")
public class ExamStatus {
	   @Id
	   private String id;
	   private String emailId;
	   private String examName;
	   private String status;
	public ExamStatus() {
		super();
	}
	public ExamStatus(String id, String emailId, String examName, String status) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.examName = examName;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "QuestionStatus [id=" + id + ", emailId=" + emailId + ", examName=" + examName + ", status=" + status
				+ "]";
	}
	
	   
	   
}
