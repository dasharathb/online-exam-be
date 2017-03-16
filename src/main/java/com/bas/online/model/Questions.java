package com.bas.online.model;

public class Questions {
	private String qNo;
	private String question;
	private Options options;
	private String answer;
	private String paperName;
	public Questions() {
		super();
	}
	public Questions(String qNo, String question, Options options, String answer, String paperName) {
		super();
		this.qNo = qNo;
		this.question = question;
		this.options = options;
		this.answer = answer;
		this.paperName = paperName;
	}
	public String getqNo() {
		return qNo;
	}
	public void setqNo(String qNo) {
		this.qNo = qNo;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Options getOptions() {
		return options;
	}
	public void setOptions(Options options) {
		this.options = options;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	@Override
	public String toString() {
		return "Questions [qNo=" + qNo + ", question=" + question + ", options=" + options + ", answer=" + answer
				+ ", paperName=" + paperName + "]";
	}
		
	
	

}
