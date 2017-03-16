package com.bas.online.mongo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bas.online.model.LoginDtl;



public interface LoginRepo extends PagingAndSortingRepository<LoginDtl, String>{
	

}


