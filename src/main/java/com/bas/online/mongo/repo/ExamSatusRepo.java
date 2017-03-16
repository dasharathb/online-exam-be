package com.bas.online.mongo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bas.online.model.ExamStatus;

public interface ExamSatusRepo extends PagingAndSortingRepository<ExamStatus, String>{

	public ExamStatus findByEmailId(String emailId);
	

}


