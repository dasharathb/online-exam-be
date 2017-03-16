package com.bas.online.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bas.online.dao.UserDao;
import com.bas.online.model.LoginDtl;
import com.bas.online.model.StdDtl;
@Service(value="userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	@Override
	public StdDtl getRegDtls(String email) {
		return userDao.getRegDtls(email);
		
	}

	@Override
	public void saveUserDtl(StdDtl stdDtl) {
		LoginDtl loginDtl = setLoginData(stdDtl);
		userDao.saveLoginDtl(loginDtl);
		
		stdDtl.setPassword(null);
		userDao.saveUserDtl(stdDtl);
		
	
		
	}

	private LoginDtl setLoginData(StdDtl stdDtl) {
		LoginDtl loginDtl = new LoginDtl();
		loginDtl.setFirstName(stdDtl.getFirstName());
		loginDtl.setLastName(stdDtl.getLastName());
		loginDtl.setEmail(stdDtl.getEmail());
		loginDtl.setPhone(stdDtl.getPhone());
		loginDtl.setPassword(stdDtl.getPassword());
		return loginDtl;
	}

	@Override
	public LoginDtl getLoginDtls(LoginDtl dtl) {
		
    LoginDtl loginDtl = userDao.getLoginDtl(dtl);
		
		if(loginDtl != null){
			return loginDtl;
		}
		
		return null;
		
	
	}

	@Override
	public StdDtl getUserDetails(LoginDtl loginDtl) {
		return userDao.getUserDetails(loginDtl);
		

	}

	

}
