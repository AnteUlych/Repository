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
	
	public List<Tender> getOpenTenders() {
		return dao.getOpenTenders();
	}
	
	public List<Tender> getOpenTendersByCompanyId(int companyId){
		return dao.getOpenTendersByCompanyId(companyId);
	}
	
	public int getNumberOfTendersByCompanyId(int companyId) {
		return dao.getTendersByCompanyId(companyId).size();
	}
	
	public List<Tender> getOpenTendersFiltr(int more, int less, String countryfrom, String countryto) {
		
		if(countryfrom.equals("-")&&countryto.equals("-")){
			return dao.getOpenTendersFiltrWeight(more, less);
		}
        if(!countryfrom.equals("-")&&countryto.equals("-")){
			return dao.getOpenTendersFiltrFrom(more, less, countryfrom);
		}
        if(countryfrom.equals("-")&&!countryto.equals("-")){
			return dao.getOpenTendersFiltrTo(more, less, countryto);
		}
        if(!countryfrom.equals("-")&&!countryto.equals("-")){
			return dao.getOpenTendersFiltrFromTo(more, less, countryfrom, countryto);
		
		}
        return dao.getOpenTendersFiltrWeight(more, less);
	}
	
	
}
