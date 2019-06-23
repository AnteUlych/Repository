package lotos.service;

import java.util.List;

import lotos.dao.PropositionDAO;
import lotos.model.Proposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("PropositionService")
@Transactional
public class PropositionService {
	
	@Autowired
	private PropositionDAO dao;
	
	public void deleteProposition(int propositionId) {
		dao.deleteProposition(propositionId);
	}
	
	public void addProposition(int tenderid, int companyid, String company, String dateproposition, String transport, String pickup, String deliverydate, int price, String currency, String otherinformation){
		
		Proposition proposition = new Proposition();
		
		proposition.setTenderid(tenderid);
		proposition.setCompanyid(companyid);
		proposition.setCompany(company);
		proposition.setDateproposition(dateproposition);
		proposition.setTransport(transport);
		proposition.setPickup(pickup);
		proposition.setDeliverydate(deliverydate);
		proposition.setPrice(price);
		proposition.setCurrency(currency);
		proposition.setOtherinformation(otherinformation);
		
		dao.persist(proposition);
		
	}

	public List<Proposition> getPropositionsByTenderId(int tenderId) {
		return dao.getPropositionsByTenderId(tenderId);
	}
	
	public List<Proposition> getPropositionsByCompanyId(int companyId) {
		return dao.getPropositionsByCompanyId(companyId);
	}
}
