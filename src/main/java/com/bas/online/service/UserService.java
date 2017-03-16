package com.bas.online.service;

import com.bas.online.model.LoginDtl;
import com.bas.online.model.StdDtl;

public interface UserService {
	public StdDtl getRegDtls(String email);

	public void saveUserDtl(StdDtl stdDtl);

	public LoginDtl getLoginDtls(LoginDtl loginDtl);

	public StdDtl getUserDetails(LoginDtl loginDtl);

	

}
