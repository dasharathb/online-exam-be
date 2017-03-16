package com.bas.online.dao;

import java.util.List;

import com.bas.online.model.BankPaper;
import com.bas.online.model.ExamStatus;
import com.bas.online.model.GatePaper;
import com.bas.online.model.QPSequence;
import com.bas.online.model.QuestionPaper;
import com.bas.online.model.Questions;
import com.bas.online.model.RRBPaper;
import com.bas.online.model.SSCPaper;

public interface QuestionDao {

	void saveQuestions(QuestionPaper qPaper);

	public QuestionPaper getPaper(Integer exam,String string3);

	QPSequence getQPSequence(String pType);



	QuestionPaper viewPapers(String qPaper);

	List<QuestionPaper> getQpId();

	void saveStatus(ExamStatus paperStatus);

	void saveRRB(RRBPaper rrbPaper1);

	void saveGate(GatePaper gatePaper1);

	void saveBank(BankPaper bankPaper1);

	void saveSSC(SSCPaper sscPaper1);

	List<RRBPaper> getRRBId();

	RRBPaper viewRRBPapers(String rrbview);

	List<SSCPaper> getSSCId();

	SSCPaper viewSSCPapers(String sscview);

	List<BankPaper> getBankId();

	List<GatePaper> getGateId();

	BankPaper viewBankPapers(String bankview);

	GatePaper viewGatePapers(String gateview);



	




	

}
