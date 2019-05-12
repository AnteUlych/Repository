package lotos.service;

import java.util.List;

import lotos.dao.DealDAO;
import lotos.model.Deal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("DealService")
@Transactional
public class DealService {
	@Autowired
	private DealDAO dao;
	
	public List<Deal> getDealsByCompanyOrPropositionId(int companytenderid, int companypropositionid) {
		return dao.getDealsByCompanyOrPropositionId(companytenderid, companypropositionid);
	}
	
	public int getNumberofClosingDealsByCompanyId(int companytenderid) {
		return dao.getClosingDealsByCompanyId(companytenderid).size();
	}
	
	public int getNumberWinningDealsByCompanyId(int companypropositionid) {
		return dao.getWinningDealsByCompanyId(companypropositionid).size();
	}
}
