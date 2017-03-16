package com.bas.online.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Component;

import com.bas.online.model.BankPaper;
import com.bas.online.model.ExamStatus;
import com.bas.online.model.GatePaper;
import com.bas.online.model.QPSequence;
import com.bas.online.model.QuestionPaper;
import com.bas.online.model.RRBPaper;
import com.bas.online.model.SSCPaper;
import com.bas.online.mongo.repo.LoginRepo;

@Component(value="questionDao")
public class QuestionDaoImpl implements QuestionDao {
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	LoginRepo loginRepo;

	@Override
	public void saveQuestions(QuestionPaper qPaper) {
		
	  mongoTemplate.save(qPaper);
	
	}

	@Override
	public QuestionPaper getPaper(Integer exam,String string3) {
		QuestionPaper questions;
		if(string3.equals("RRB")){
			String queryObject = "";
			queryObject = "{'id' : 'RRB"+exam+"'}";
			BasicQuery query=new BasicQuery(queryObject);
			questions = mongoTemplate.findOne(query, RRBPaper.class);
			//System.out.println("----->"+questions.toString());
			
		}else if(string3.equals("SSC")){
			String queryObject = "";
			queryObject = "{'id' : 'SSC"+exam+"'}";
			BasicQuery query=new BasicQuery(queryObject);
			questions = mongoTemplate.findOne(query, SSCPaper.class);
			//System.out.println("----->"+questions.toString());
		}else if(string3.equals("GATE")){
			String queryObject = "";
			queryObject = "{'id' : 'GATE"+exam+"'}";
			BasicQuery query=new BasicQuery(queryObject);
			questions = mongoTemplate.findOne(query, GatePaper.class);
			//System.out.println("----->"+questions.toString());
		}else if(string3.equals("BANK")){
			String queryObject = "";
			queryObject = "{'id' : 'BANK"+exam+"'}";
			BasicQuery query=new BasicQuery(queryObject);
			questions = mongoTemplate.findOne(query, BankPaper.class);
			//System.out.println("----->"+questions.toString());
			
		}else{
		String queryObject = "";
		queryObject = "{'id' : 'AD"+exam+"'}";
		BasicQuery query=new BasicQuery(queryObject);
		questions = mongoTemplate.findOne(query, QuestionPaper.class);
		//System.out.println("----->"+questions.toString());
		}
		return questions;
		
	}

	@Override
	public QPSequence getQPSequence(String pType) {
		QPSequence q=mongoTemplate.findById(pType, QPSequence.class);
		if(q==null){
			q = new QPSequence(pType, 001);
		}
		mongoTemplate.save(new QPSequence(pType, q.getQpId()+1));
		return q;
	}

	

	@Override
	public QuestionPaper viewPapers(String qPaper) {
		QuestionPaper q;
		if(qPaper.contains("RRB")){
			String queryObject = "";
			queryObject = "{'id' : '"+qPaper+"'}";
			BasicQuery query=new BasicQuery(queryObject);
			 q =  mongoTemplate.findOne(query,RRBPaper.class);
		}else if(qPaper.contains("SSC")){
			String queryObject = "";
			queryObject = "{'id' : '"+qPaper+"'}";
			BasicQuery query=new BasicQuery(queryObject);
			 q =  mongoTemplate.findOne(query,SSCPaper.class);
		}else if(qPaper.contains("GATE")){
			String queryObject = "";
			queryObject = "{'id' : '"+qPaper+"'}";
			BasicQuery query=new BasicQuery(queryObject);
			 q =  mongoTemplate.findOne(query,GatePaper.class);
		}else if(qPaper.contains("BANK")){
			String queryObject = "";
			queryObject = "{'id' : '"+qPaper+"'}";
			BasicQuery query=new BasicQuery(queryObject);
			 q =  mongoTemplate.findOne(query,BankPaper.class);
		}else{
			String queryObject = "";
			queryObject = "{'id' : '"+qPaper+"'}";
			BasicQuery query=new BasicQuery(queryObject);
			 q =  mongoTemplate.findOne(query,QuestionPaper.class);
		}
		
		return q;
	}

	@Override
	public List<QuestionPaper> getQpId() {

		List<QuestionPaper> questions = mongoTemplate.findAll(QuestionPaper.class);
		System.out.println("----->"+questions.toString());
		return questions;
	}

	@Override
	public void saveStatus(ExamStatus paperStatus) {
		mongoTemplate.save(paperStatus);
		
	}

	@Override
	public void saveRRB(RRBPaper rrbPaper1) {
		mongoTemplate.save(rrbPaper1);
		
	}

	@Override
	public void saveGate(GatePaper gatePaper1) {
		mongoTemplate.save(gatePaper1);
		
	}

	@Override
	public void saveBank(BankPaper bankPaper1) {
		mongoTemplate.save(bankPaper1);
		
	}

	@Override
	public void saveSSC(SSCPaper sscPaper1) {
		mongoTemplate.save(sscPaper1);
		
	}

	@Override
	public List<RRBPaper> getRRBId() {
		List<RRBPaper> rrbQuestions = mongoTemplate.findAll(RRBPaper.class);
		System.out.println("----->"+rrbQuestions.toString());
		return rrbQuestions;
	}

	@Override
	public RRBPaper viewRRBPapers(String rrbview) {
		String queryObject = "";
		queryObject = "{'id' : '"+rrbview+"'}";
		BasicQuery query=new BasicQuery(queryObject);

		RRBPaper q =  mongoTemplate.findOne(query,RRBPaper.class);
		return q;
	}

	@Override
	public List<SSCPaper> getSSCId() {
		List<SSCPaper> sscQuestions = mongoTemplate.findAll(SSCPaper.class);
		System.out.println("----->"+sscQuestions.toString());
		return sscQuestions;
	}

	@Override
	public SSCPaper viewSSCPapers(String sscview) {
		String queryObject = "";
		queryObject = "{'id' : '"+sscview+"'}";
		BasicQuery query=new BasicQuery(queryObject);

		SSCPaper q =  mongoTemplate.findOne(query,SSCPaper.class);
		return q;
	}

	@Override
	public List<BankPaper> getBankId() {
		List<BankPaper> bankQuestions = mongoTemplate.findAll(BankPaper.class);
		System.out.println("----->"+bankQuestions.toString());
		return bankQuestions;
	}

	@Override
	public List<GatePaper> getGateId() {
		List<GatePaper> gateQuestions = mongoTemplate.findAll(GatePaper.class);
		System.out.println("----->"+gateQuestions.toString());
		return gateQuestions;
	}

	@Override
	public BankPaper viewBankPapers(String bankview) {
		String queryObject = "";
		queryObject = "{'id' : '"+bankview+"'}";
		BasicQuery query=new BasicQuery(queryObject);

		BankPaper q =  mongoTemplate.findOne(query,BankPaper.class);
		return q;
	}

	@Override
	public GatePaper viewGatePapers(String gateview) {
		String queryObject = "";
		queryObject = "{'id' : '"+gateview+"'}";
		BasicQuery query=new BasicQuery(queryObject);

		GatePaper q =  mongoTemplate.findOne(query,GatePaper.class);
		return q;
	}

	

	

}
