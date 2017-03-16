package com.bas.online.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Component;

import com.bas.online.model.LoginDtl;
import com.bas.online.model.StdDtl;
import com.bas.online.mongo.repo.LoginRepo;





@Component(value="userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	LoginRepo loginRepo;

	@Override
	public LoginDtl getLoginDtl(LoginDtl dtl) {
		LoginDtl loginDtl = null;
		/*DBObject dbObj = null;
		DBCollection collection = mongoTemplate.getCollection(Constants.LOGIN_DLT);*/
		String queryObject = "";
		if(dtl.getEmail() != null && dtl.getEmail()!=""){
			queryObject = "{'email' : '"+dtl.getEmail()+"'}";
		}
		if(dtl.getPhone() != null){
			queryObject = "{'phone' : '"+dtl.getPhone()+"'}";
		}

		BasicQuery query= new BasicQuery(queryObject);
		loginDtl = mongoTemplate.findOne(query, LoginDtl.class);
		/*if(dbCursor.hasNext()){
			dbObj = dbCursor.next();
			loginDtl = (LoginDtl) dbObj;
			
		}*/

		//insert();
		//LoginDtl loginDtl = loginRepo.findByUserName(userName);
		return loginDtl;

	}

	@Override
	public StdDtl getRegDtls(String email) {
		String queryObject = "";
		queryObject = "{'email' : '"+email+"'}";
		BasicQuery query=new BasicQuery(queryObject);

		StdDtl userdtl =  mongoTemplate.findOne(query,StdDtl.class);
		return userdtl;
	}

	@Override
	public void saveUserDtl(StdDtl stdDtl) {
		mongoTemplate.save(stdDtl);
	}

	@Override
	public void saveLoginDtl(LoginDtl loginDtl) {
		mongoTemplate.save(loginDtl);
		
		
	}

	@Override
	public StdDtl getUserDetails(LoginDtl loginDtl) {
		StdDtl userdtl=null;
		String queryObject="";
		/*DBCollection collection=mongoTemplate.getCollection(Constants.USER_DLT);*/
		if(loginDtl.getEmail()!=null && loginDtl.getEmail()!=""){
			queryObject = "{'email' : '"+loginDtl.getEmail()+"'}";
		}
		if(loginDtl.getPhone()!=null){
			queryObject = "{'phone': '"+loginDtl.getPhone()+"'}";
		}
		/*DBCursor dbCursor =collection.find(query);
		if(dbCursor.hasNext()){
			userdtl=(UserDtl) dbCursor.next();
			
		}*/
		BasicQuery query=new BasicQuery(queryObject);
		userdtl =mongoTemplate.findOne(query,StdDtl.class );
		

		return userdtl;

	}

	@Override
	public StdDtl getUserDtl(String email) {
		//BasicQuery query=new BasicQuery();
				String queryObject = "";
				queryObject = "{'email' : '"+email+"'}";
				BasicQuery query=new BasicQuery(queryObject);
				StdDtl userdtl = mongoTemplate.findOne(query,StdDtl.class );
				
				return userdtl;
	}
	

}
