package com.bas.online.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="qp-sequence")
public class QPSequence {
	@Id
	private String id;
	private int qpId;
	public QPSequence() {
		super();
	}
	public QPSequence(String id, int qpId) {
		super();
		this.id = id;
		this.qpId = qpId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQpId() {
		return qpId;
	}
	public void setQpId(int qpId) {
		this.qpId = qpId;
	}
	@Override
	public String toString() {
		return "QPSequence [id=" + id + ", qpId=" + qpId + "]";
	}
	
	
	

}
