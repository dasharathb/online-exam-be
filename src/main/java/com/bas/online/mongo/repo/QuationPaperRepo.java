package com.bas.online.mongo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bas.online.model.ExamStatus;
import com.bas.online.model.QuestionPaper;

public interface QuationPaperRepo extends PagingAndSortingRepository<QuestionPaper, String>{

	//public ExamStatus findByEmailId(String emailId);
	

}


