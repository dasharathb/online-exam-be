package com.bas.online.dao;

import com.bas.online.model.LoginDtl;
import com.bas.online.model.StdDtl;

public interface UserDao {

	LoginDtl getLoginDtl(LoginDtl dtl);

	StdDtl getRegDtls(String email);

	void saveUserDtl(StdDtl stdDtl);

	void saveLoginDtl(LoginDtl loginDtl);

	StdDtl getUserDetails(LoginDtl loginDtl);

	StdDtl getUserDtl(String email);




}
