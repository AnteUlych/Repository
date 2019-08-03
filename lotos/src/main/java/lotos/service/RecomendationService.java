package lotos.service;

import java.util.List;

import lotos.dao.RecomendationDAO;
import lotos.model.Recomendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("RecomendationService")
@Transactional
public class RecomendationService {

	@Autowired
	private RecomendationDAO dao;
	
	public void deleteRecomendation(int id) {
	    dao.deleteRecomendation(id);	
	}
	
	public void hideRecomendation(int id) {
		dao.hideRecomendation(id);
	}
	
	public Recomendation getRecomendationById(int id) {
		return dao.getRecomendationById(id);
	}
	
	public List<Recomendation> getListRecomendationsByCompanyId(int companyid) {
		return dao.getListRecomendationsByCompanyId(companyid);
	}
	
	public int getNumberOfRecomendationByCompanyId(int companyid, String rate) {
		return dao.getRecomendationsByCompanyId(companyid, rate).size();
	}
	
	public List<Recomendation> getRecomendationsByCompanyId(int companyid, String rate) {
		return dao.getRecomendationsByCompanyId(companyid, rate);
	}
	
	public Recomendation getRecomendationByDealId(int dealid) {
		return dao.getRecomendationByDealId(dealid);
	}
	
	public void addRecommendation(int dealid, int companyid, int companytenderid, int companytransportationid, String companytender, String companyproposition, String dealdate, String recomendationdate, String incoterms, String countryfrom, String countryto, int weight, String transport, String rate, String whyinfo){
		
		Recomendation rec = new Recomendation();
		
		rec.setCompanyid(companyid);
		rec.setCompanyproposition(companyproposition);
		rec.setCompanytender(companytender);
		rec.setCompanytenderid(companytenderid);
		rec.setCompanytransportationid(companytransportationid);
		rec.setCountryfrom(countryfrom);
		rec.setCountryto(countryto);
		rec.setDealdate(dealdate);
		rec.setDealid(dealid);
		rec.setIncoterms(incoterms);
		rec.setIncoterms(incoterms);
		rec.setRate(rate);
		rec.setRecomendationdate(recomendationdate);
		rec.setTransport(transport);
		rec.setWeight(weight);
		rec.setWhyinfo(whyinfo);
		
		dao.persist(rec);
		
	}
}
