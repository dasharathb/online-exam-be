package com.bas.online.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bas.online.model.RespObject;
import com.bas.online.model.StdDtl;
import com.bas.online.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.RawDBObject;


@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/regUser" , method=RequestMethod.GET )
	public @ResponseBody <userService> Object regUser(@RequestParam(value="userDtl") Object uDtl,HttpServletRequest request ,HttpServletResponse response){
		ObjectMapper objMapper=new ObjectMapper();
		StdDtl stdDtl=null;
		StdDtl dtl=null;
		RespObject respObject = new RespObject();
		//
		
		try{
			System.out.println(uDtl.toString());
			stdDtl = objMapper.readValue(uDtl.toString(), StdDtl.class);
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
	
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		System.out.println("User deatails*********************"+stdDtl.toString());
		
		dtl = userService.getRegDtls(stdDtl.getEmail());
	
		
		
		if(dtl!=null){
			respObject.setMessage("user already exist");
		}else{
			userService.saveUserDtl(stdDtl);
			respObject.setMessage("user registerd seccessfully");
		}
		
		return respObject;
	}
		

}
