package com.bas.online.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bas.online.dao.QuestionDao;
import com.bas.online.model.BankPaper;
import com.bas.online.model.ExamStatus;
import com.bas.online.model.GatePaper;
import com.bas.online.model.QPSequence;
import com.bas.online.model.QuestionPaper;
import com.bas.online.model.RRBPaper;
import com.bas.online.model.SSCPaper;
import com.bas.online.mongo.repo.ExamSatusRepo;
import com.bas.online.mongo.repo.QuationPaperRepo;
@Service(value="qService")
public class QuestionServiceImpl implements QuestionService  {
    
	@Autowired
	ExamSatusRepo examSatusRepo;
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	QuationPaperRepo quationPaperRepo;

	@Override
	public void saveQuestionPaper(QuestionPaper qPaper ) {
		qPaper.setId("AD"+getQuestionSequence("AD"));
		System.out.println(qPaper);
		  questionDao.saveQuestions(qPaper);		 

	}

	@Override
	public QuestionPaper getQuestionPaper(String emailId,String string3) {
		ExamStatus examStatus = examSatusRepo.findByEmailId(emailId);
		String exmName = "0";
		Integer exm = 1;
		if(examStatus != null){
			exmName = examStatus.getExamName().substring(string3.length(), examStatus.getExamName().length());
			exm = new Integer(exmName);
			exm++;
		}		 
		System.out.println("exm :::::::::::::: "+exm+string3);
		return questionDao.getPaper(exm,string3);
	}
	private int getQuestionSequence(String pType){
		QPSequence q= questionDao.getQPSequence(pType);		
		return q.getQpId();
		
	}

	@Override
	public QuestionPaper viewPaper(String papers) {
		return questionDao.viewPapers(papers) ;
	}

	@Override
	public List<QuestionPaper> getQPId() {
	
		return questionDao.getQpId();
	}

	@Override
	public void savePaperStatus(ExamStatus paperStatus) {
		questionDao.saveStatus(paperStatus);
		
	}

	@Override
	public void saveRRBPaper(RRBPaper rrbPaper1) {
		rrbPaper1.setId("RRB"+getQuestionSequence("RRB"));
		System.out.println(rrbPaper1);	
		questionDao.saveRRB(rrbPaper1);
		
	}

	@Override
	public void saveGatePaper(GatePaper gatePaper1) {
		gatePaper1.setId("GATE"+getQuestionSequence("GATE"));
		System.out.println(gatePaper1);	
		questionDao.saveGate(gatePaper1);
		
	}

	@Override
	public void saveBankPaper(BankPaper bankPaper1) {
		bankPaper1.setId("BANK"+getQuestionSequence("BANK"));
		System.out.println(bankPaper1);	
		questionDao.saveBank(bankPaper1);
		
	}

	@Override
	public void saveSSCPaper(SSCPaper sscPaper1) {
		sscPaper1.setId("SSC"+getQuestionSequence("SSC"));
		System.out.println(sscPaper1);	
		questionDao.saveSSC(sscPaper1);
		
	}

	@Override
	public List<RRBPaper> getIdRRB() {
		return questionDao.getRRBId();
	
	}

	@Override
	public RRBPaper viewRRBPaper(String rrbview) {
		return questionDao.viewRRBPapers(rrbview) ;
	}

	@Override
	public List<SSCPaper> getIdSSC() {
		return questionDao.getSSCId();
	}

	@Override
	public SSCPaper viewSSCPaper(String sscview) {
		return questionDao.viewSSCPapers(sscview) ;
	}

	@Override
	public List<BankPaper> getIdBank() {
		return questionDao.getBankId();
	}

	@Override
	public BankPaper viewBankPaper(String bankview) {
		return questionDao.viewBankPapers(bankview) ;
	}

	@Override
	public GatePaper viewGatePaper(String gateview) {
		return questionDao.viewGatePapers(gateview) ;
	}

	@Override
	public List<GatePaper> getIdGate() {
		return questionDao.getGateId();
	}

	
	


	

	}


