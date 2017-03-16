package com.bas.online.service;

import java.util.List;

import com.bas.online.model.BankPaper;
import com.bas.online.model.ExamStatus;
import com.bas.online.model.GatePaper;
import com.bas.online.model.QuestionPaper;
import com.bas.online.model.Questions;
import com.bas.online.model.RRBPaper;
import com.bas.online.model.SSCPaper;

public interface QuestionService {

	
	
	public QuestionPaper viewPaper(String paper);

	public QuestionPaper getQuestionPaper(String emailId,String string3);

	List<QuestionPaper> getQPId();

	void savePaperStatus(ExamStatus paperStatus);

	void saveRRBPaper(RRBPaper qnPaper1);

	void saveGatePaper(GatePaper gatePaper1);

	void saveBankPaper(BankPaper bankPaper1);

	void saveSSCPaper(SSCPaper sscPaper1);

	List<RRBPaper> getIdRRB();

	RRBPaper viewRRBPaper(String rrbview);

	List<SSCPaper> getIdSSC();

	SSCPaper viewSSCPaper(String sscview);


	List<BankPaper> getIdBank();

	BankPaper viewBankPaper(String bankview);

	GatePaper viewGatePaper(String gateview);

	List<GatePaper> getIdGate();

	public void saveQuestionPaper(QuestionPaper qPaper);


	

	

	
	

}
