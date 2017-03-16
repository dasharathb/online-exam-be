package com.bas.online.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bas.online.model.LoginDtl;
import com.bas.online.model.StdDtl;
import com.bas.online.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public @ResponseBody Object login(@RequestParam(value="login") Object login, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		LoginDtl loginDtl = null;
		LoginDtl dtl = null;
		StdDtl stdDtl = null;
		try {
			loginDtl = objMapper.readValue(login.toString(), LoginDtl.class);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("loginDtl ::::::::::::::: "+loginDtl.toString());
		
		dtl = userService.getLoginDtls(loginDtl);
		if(dtl == null){
			return stdDtl;
		}else if(!dtl.getPassword().equals(loginDtl.getPassword())){
			return stdDtl;
		}
		
		stdDtl = userService.getUserDetails(loginDtl);
		System.out.println("userDtl ::::::"+stdDtl.toString());
		return stdDtl;
	}
	


}
