package lotos.service;

import java.util.Date;
import java.util.List;

import lotos.dao.TenderDAO;
import lotos.logic.SimpleLogic;
import lotos.model.Tender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TenderService")
@Transactional
public class TenderService {

	@Autowired
	private TenderDAO dao;
	
	public void deleteTender(int tenderId){
		dao.deleteTender(tenderId);
	}
	
	
	public void closeTender(int tenderId) {
		dao.closeTender(tenderId);
	}
	
	public Tender getTenderByTenderId(int tenderId) {
		return dao.getTenderByTenderId(tenderId);
	}
	
	public void addTender(int companyid, String company, int weight, String size, String readytopickup, String appdelivery, Date timetoendtender, String countryfrom, String countryto, String possibletransport, String payconditions, int dayspay, String freightinformationandconditions, String visiability, String addresstopickup, String addresstodelivery, String incoterms){
		
		Tender tender = new Tender();
		
		tender.setAddresstodelivery(addresstodelivery);
		tender.setAddresstopickup(addresstopickup);
		tender.setAppdelivery(appdelivery);
		tender.setCompany(company);
		tender.setCompanyid(companyid);
		tender.setCountryfrom(countryfrom);
		tender.setCountryto(countryto);
		
		SimpleLogic simple = new SimpleLogic();
		
		tender.setDateofopening(simple.fixDateInString());
		tender.setDatetimecreation(new Date());
		tender.setDayspay(dayspay);
		tender.setFreightinformationandconditions(freightinformationandconditions);
		tender.setIncoterms(incoterms);
		tender.setIsopen("open");
		tender.setPayconditions(payconditions);
		tender.setPossibletransport(possibletransport);
		tender.setReadytopickup(readytopickup);
		tender.setSize(size);
		tender.setTimetoendtender(timetoendtender);
		tender.setVisiability(visiability);
		tender.setWeight(weight);
		
		dao.persist(tender);
	}
	
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
