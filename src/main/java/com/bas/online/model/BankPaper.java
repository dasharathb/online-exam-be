package com.bas.online.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bankPaper")
public class BankPaper extends QuestionPaper{
	
}
