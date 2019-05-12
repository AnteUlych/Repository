package lotos.service;

import java.util.List;

import lotos.dao.TenderDAO;
import lotos.model.Tender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TenderService")
@Transactional
public class TenderService {

	@Autowired
	private TenderDAO dao;
	
	public List<Tender> getOpenTendersByCompanyId(int companyId){
		return dao.getOpenTendersByCompanyId(companyId);
	}
	
	public int getNumberOfTendersByCompanyId(int companyId) {
		return dao.getTendersByCompanyId(companyId).size();
	}
	
}
