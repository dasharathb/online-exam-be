package com.bas.online.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bas.online.model.BankPaper;
import com.bas.online.model.ExamStatus;
import com.bas.online.model.GatePaper;
import com.bas.online.model.QuestionPaper;
import com.bas.online.model.Questions;
import com.bas.online.model.RRBPaper;
import com.bas.online.model.RespObject;
import com.bas.online.model.SSCPaper;
import com.bas.online.model.StdDtl;
import com.bas.online.service.QuestionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class QuestionPaperController {
	@Autowired
	QuestionService qService;
	
	@RequestMapping(value="/saveQuestions", method=RequestMethod.GET)
	public @ResponseBody <qService> Object saveQuestion(@RequestParam(value="qnPaper") Object qnPaper, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		QuestionPaper qPaper = null;
		QuestionPaper dtl = null;
		RespObject respObject = new RespObject();
		try {
			qPaper =  objMapper.readValue(qnPaper.toString(), QuestionPaper.class);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("question  ::::::::::::::: "+qPaper.toString());
		
	     qService.saveQuestionPaper(qPaper);
	     respObject.setMessage("Details Add successfully");
		 return respObject;
		
	 }
	
	@RequestMapping(value="/getPaper", method=RequestMethod.GET)
    public @ResponseBody QuestionPaper getQuestionPaper(@RequestParam(value="emailId") String emailId,  HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		StdDtl qPaper = null;
		QuestionPaper dtl = null;
		
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		String[] paperType = emailId.split("-");
		String string1=paperType[0];
		String string2=paperType[1];
		String[] paperType1 = string2.split("@");
		String string3=paperType1[0];
		
		
		System.out.println(string3);
		
		 dtl= qService.getQuestionPaper(emailId,string3);
		 System.out.println("::::::::"+dtl);
		 return dtl;
	 }
	
	@RequestMapping(value="/viewPaper", method=RequestMethod.GET)
	public @ResponseBody QuestionPaper viewPapers(@RequestParam(value="papers") String papers, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("question  ::::::::::::::: "+papers);
		
		 return  qService.viewPaper(papers);
		
	 }
	
	@RequestMapping(value="/qpId", method=RequestMethod.GET)
    public @ResponseBody List<QuestionPaper> getQPId( HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		StdDtl qPaper = null;
		List<QuestionPaper> dtl = null;
		
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		
		 dtl= qService.getQPId();
		 System.out.println("::::::::"+dtl);
		 return dtl;
	 }
	
	@RequestMapping(value="/examStatus", method=RequestMethod.GET)
	public @ResponseBody void saveStatus(@RequestParam(value="examStatus") Object status, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		ExamStatus paperStatus = null;
		Questions dtl = null;
		try {
			paperStatus =  objMapper.readValue(status.toString(), ExamStatus.class);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("question  ::::::::::::::: "+paperStatus.toString());
		paperStatus.setId(paperStatus.getEmailId());
		 qService.savePaperStatus(paperStatus);
	 }
	
	@RequestMapping(value="/rrbPaper", method=RequestMethod.GET)
	public @ResponseBody <qService> Object saveRRBQuestion(@RequestParam(value="qnPaper") Object qnPaper, HttpServletRequest request, HttpServletResponse response){
				
		ObjectMapper objMapper = new ObjectMapper();
		RRBPaper rrbPaper1 = null;
		Questions dtl = null;
		RespObject respObject = new RespObject();
		try {
			rrbPaper1 =  objMapper.readValue(qnPaper.toString(), RRBPaper.class);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("question  ::::::::::::::: "+rrbPaper1.toString());
		
		 qService.saveRRBPaper(rrbPaper1);
		 respObject.setMessage("RRB Details Add successfully");
		 return respObject;
	}
	
	@RequestMapping(value="/rrbId", method=RequestMethod.GET)
    public @ResponseBody List<RRBPaper> getRRBId( HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		StdDtl qPaper = null;
		List<RRBPaper> dtl = null;
		
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		
		 dtl= qService.getIdRRB();
		 System.out.println("::::::::"+dtl);
		 return dtl;
	 }
	@RequestMapping(value="/rrbview", method=RequestMethod.GET)
	public @ResponseBody RRBPaper viewRRBPapers(@RequestParam(value="rrbview") String rrbview, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("question  ::::::::::::::: "+rrbview);
		
		 return  qService.viewRRBPaper(rrbview);
		
	 }
	@RequestMapping(value="/sscPaper", method=RequestMethod.GET)
	public  @ResponseBody <qService> Object saveSSCQuestion(@RequestParam(value="qnPaper") Object qnPaper, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		RespObject respObject = new RespObject();
		SSCPaper sscPaper1 = null;
		Questions dtl = null;
		try {
			sscPaper1 =  objMapper.readValue(qnPaper.toString(), SSCPaper.class);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("question  ::::::::::::::: "+sscPaper1.toString());
		
		 qService.saveSSCPaper(sscPaper1);
		 respObject.setMessage("SSC Details Add successfully");
		 return respObject;
	 }
	@RequestMapping(value="/sscId", method=RequestMethod.GET)
    public @ResponseBody List<SSCPaper> getSSCId( HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		StdDtl qPaper = null;
		List<SSCPaper> dtl = null;
		
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		
		 dtl= qService.getIdSSC();
		 System.out.println("::::::::"+dtl);
		 return dtl;
	 }
	@RequestMapping(value="/sscview", method=RequestMethod.GET)
	public @ResponseBody SSCPaper viewSSCPapers(@RequestParam(value="sscview") String sscview, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("question  ::::::::::::::: "+sscview);
		
		 return  qService.viewSSCPaper(sscview);
		
	 }
	
	@RequestMapping(value="/gatePaper", method=RequestMethod.GET)
	public @ResponseBody <qService> Object saveGateuestion(@RequestParam(value="qnPaper") Object qnPaper, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		GatePaper gatePaper1 = null;
		Questions dtl = null;
		RespObject respObject = new RespObject();
		try {
			gatePaper1 =  objMapper.readValue(qnPaper.toString(), GatePaper.class);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("question  ::::::::::::::: "+gatePaper1.toString());
		
		 qService.saveGatePaper(gatePaper1);
		 respObject.setMessage("GATE Details Add successfully");
		 return respObject;
	 }
	@RequestMapping(value="/gateId", method=RequestMethod.GET)
    public @ResponseBody List<GatePaper> getGateId( HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		StdDtl qPaper = null;
		List<GatePaper> dtl = null;
		
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		
		 dtl= qService.getIdGate();
		 System.out.println("::::::::"+dtl);
		 return dtl;
	 }
	@RequestMapping(value="/gateview", method=RequestMethod.GET)
	public @ResponseBody GatePaper viewGatePapers(@RequestParam(value="gateview") String gateview, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("question  ::::::::::::::: "+gateview);
		
		 return  qService.viewGatePaper(gateview);
		
	 }
	
	@RequestMapping(value="/bankPaper", method=RequestMethod.GET)
	public @ResponseBody <qService> Object saveBankQuestion(@RequestParam(value="qnPaper") Object qnPaper, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		BankPaper bankPaper1 = null;
		Questions dtl = null;
		RespObject respObject = new RespObject();
		try {
			bankPaper1 =  objMapper.readValue(qnPaper.toString(), BankPaper.class);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("question  ::::::::::::::: "+bankPaper1.toString());
		
		 qService.saveBankPaper(bankPaper1);
		 respObject.setMessage("BANK Details Add successfully");
		 return respObject;
	 }
	@RequestMapping(value="/bankId", method=RequestMethod.GET)
    public @ResponseBody List<BankPaper> getBankId( HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		StdDtl qPaper = null;
		List<BankPaper> dtl = null;
		
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		
		 dtl= qService.getIdBank();
		 System.out.println("::::::::"+dtl);
		 return dtl;
	 }
	@RequestMapping(value="/bankview", method=RequestMethod.GET)
	public @ResponseBody BankPaper viewBankPapers(@RequestParam(value="bankview") String bankview, HttpServletRequest request, HttpServletResponse response){
		
		ObjectMapper objMapper = new ObjectMapper();
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		
		System.out.println("question  ::::::::::::::: "+bankview);
		
		 return  qService.viewBankPaper(bankview);
		
	 }
}
