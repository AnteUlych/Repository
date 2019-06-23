package lotos.service;

import java.util.List;

import javax.persistence.Column;

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

	public void addDeal(int tenderid, int companytenderid,
			int companypropositionid, int propositionid, String tenderstart,
			String tenderdeal, int weight, String size, String ready,
			String countryfrom, String countryto, String payterms, int dayspay,
			String freightinfo, String companytender,
			String companyproposition, String addresstopickup,
			String addresstodelivery, String deliverydate, int price,
			String currency, String freightinformationandconditions,
			String transport) {

		Deal deal = new Deal();

		deal.setTenderid(companytenderid);
		deal.setCompanytenderid(companytenderid);
		deal.setCompanypropositionid(companypropositionid);
		deal.setPropositionid(propositionid);
		deal.setTenderstart(tenderstart);
		deal.setTenderdeal(tenderdeal);
		deal.setWeight(weight);
		deal.setSize(size);
		deal.setReady(ready);
		deal.setCountryfrom(countryfrom);
		deal.setCountryto(countryto);
		deal.setPayterms(payterms);
		deal.setDayspay(dayspay);
		deal.setFreightinfo(freightinfo);
		deal.setCompanytender(companytender);
		deal.setCompanyproposition(companyproposition);
		deal.setAddresstopickup(addresstopickup);
		deal.setAddresstodelivery(addresstodelivery);
		deal.setDeliverydate(deliverydate);
		deal.setPrice(price);
		deal.setCurrency(currency);
		deal.setFreightinformationandconditions(freightinformationandconditions);
		deal.setTransport(transport);

		dao.persist(deal);
	}

	public List<Deal> getDealsByCompanyOrPropositionId(int companytenderid,
			int companypropositionid) {
		return dao.getDealsByCompanyOrPropositionId(companytenderid,
				companypropositionid);
	}

	public int getNumberofClosingDealsByCompanyId(int companytenderid) {
		return dao.getClosingDealsByCompanyId(companytenderid).size();
	}

	public int getNumberWinningDealsByCompanyId(int companypropositionid) {
		return dao.getWinningDealsByCompanyId(companypropositionid).size();
	}
}
