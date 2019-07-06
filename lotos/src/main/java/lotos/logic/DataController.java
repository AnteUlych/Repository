package lotos.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import lotos.model.Company;
import lotos.model.Deal;
import lotos.model.Proposition;
import lotos.model.Recomendation;
import lotos.model.Request;
import lotos.model.Statistic;
import lotos.model.Tender;
import lotos.service.CompanyService;
import lotos.service.DealService;
import lotos.service.PropositionService;
import lotos.service.RecomendationService;
import lotos.service.RequestService;
import lotos.service.StatisticService;
import lotos.service.TenderService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataController {

	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");
	CompanyService companyService = (CompanyService) ctx
			.getBean("companyService");
	DealService dealService = (DealService) ctx.getBean("dealService");
	PropositionService propositionService = (PropositionService) ctx
			.getBean("propositionService");
	RecomendationService recomendationService = (RecomendationService) ctx
			.getBean("recomendationService");
	RequestService requestService = (RequestService) ctx
			.getBean("requestService");
	StatisticService statisticService = (StatisticService) ctx
			.getBean("statisticService");
	TenderService tenderService = (TenderService) ctx.getBean("tenderService");

	public void closeConnection() {
		((AbstractApplicationContext) ctx).close();
	}

	// deal
	public void addDeal(int tenderid, int companytenderid,
			int companypropositionid, int propositionid, String tenderstart,
			 int weight, String size, String ready,
			String countryfrom, String countryto, String payterms, int dayspay,
			String freightinfo, String companytender,
			String companyproposition, String addresstopickup,
			String addresstodelivery, String deliverydate, int price,
			String currency, String freightinformationandconditions,
			String transport) {
		
		SimpleLogic logic = new SimpleLogic();
		
		dealService.addDeal(tenderid, companytenderid, companypropositionid,
				propositionid, tenderstart, logic.fixDateInString(), weight, size, ready,
				countryfrom, countryto, payterms, dayspay, freightinfo,
				companytender, companyproposition, addresstopickup,
				addresstodelivery, deliverydate, price, currency,
				freightinformationandconditions, transport);
	}

	public List<Deal> getDealsByCompanyOrPropositionId(int companytenderid,
			int companypropositionid) {
		return dealService.getDealsByCompanyOrPropositionId(companytenderid,
				companypropositionid);
	}
	
	public List<Deal> getDealsByCompanyId(int companytenderid) {
		return dealService.getDealsByCompanyId(companytenderid);
	}
	
	public List<Deal> getDealsByTransportId(int companypropositionid) {
		return dealService.getDealsByTransportId(companypropositionid);
	}
	
	public Deal getDealById(int id) {
		return dealService.getDealById(id);
	}

	public int getNumberofClosingDealsByCompanyId(int companytenderid) {
		return dealService.getNumberofClosingDealsByCompanyId(companytenderid);
	}

	public int getNumberWinningDealsByCompanyId(int companypropositionid) {
		return dealService
				.getNumberWinningDealsByCompanyId(companypropositionid);
	}

	// deal
	// proposition
	public void deleteProposition(int propositionId) {
		propositionService.deleteProposition(propositionId);
	}

	public void addProposition(int tenderid, int companyid, String company,
			String transport, String pickup, String deliverydate, int price,
			String currency, String otherinformation) {
		SimpleLogic today = new SimpleLogic();
		propositionService.addProposition(tenderid, companyid, company,
				today.fixDateInString(), transport, pickup, deliverydate,
				price, currency, otherinformation);
	}

	public List<Proposition> getPropositionsByTenderId(int tenderId) {
		return propositionService.getPropositionsByTenderId(tenderId);
	}

	public List<Proposition> getPropositionsByCompanyId(int companyId) {
		return propositionService.getPropositionsByCompanyId(companyId);
	}

	// proposition

	// tender

	public void deleteTender(int tenderId) {
		tenderService.deleteTender(tenderId);
	}

	public void closeTender(int tenderId) {
		tenderService.closeTender(tenderId);
	}

	public Tender getTenderByTenderId(int tenderId) {
		return tenderService.getTenderByTenderId(tenderId);
	}

	public void addTender(int companyid, String company, int weight,
			String size, String readytopickup, String appdelivery,
			Date timetoendtender, String countryfrom, String countryto,
			String possibletransport, String payconditions, int dayspay,
			String freightinformationandconditions, String visiability,
			String addresstopickup, String addresstodelivery, String incoterms) {
		tenderService.addTender(companyid, company, weight, size,
				readytopickup, appdelivery, timetoendtender, countryfrom,
				countryto, possibletransport, payconditions, dayspay,
				freightinformationandconditions, visiability, addresstopickup,
				addresstodelivery, incoterms);
	}

	public List<Tender> getOpenTenders() {
		return tenderService.getOpenTenders();
	}

	public List<Tender> getOpenTendersFiltr(int more, int less,
			String countryfrom, String countryto, String transport) {

		List<Tender> tenders = tenderService.getOpenTendersFiltr(more, less,
				countryfrom, countryto);

		if (transport.contains("any")) {
			return tenders;
		}
		List<Tender> transportTenders = new ArrayList();
		for (Tender tender : tenders) {
			if (tender.getPossibletransport().equals(transport)) {
				transportTenders.add(tender);
			}
		}
		return transportTenders;
	}

	public int getNumberOfTendersByCompanyId(int companyId) {
		return tenderService.getNumberOfTendersByCompanyId(companyId);
	}

	public List<Tender> getOpenTendersByCompanyId(int companyId) {
		return tenderService.getOpenTendersByCompanyId(companyId);
	}

	// tender

	// request
	public void createNewRequest(Request request) {
		requestService.createNewRequest(request);
	}

	public boolean isMailInRequestExist(String mail) {
		return requestService.isMailInRequestExist(mail);
	}

	public boolean isCodeInRequestExist(String code) {
		return requestService.isCodeInRequestExist(code);
	}

	// request

	// company
	public void editCompany(int id, String manager, String mail, String phone,
			String mobile, String password, String webaddress) {
		companyService.editCompany(id, manager, mail, phone, mobile, password,
				webaddress);
	}

	public int getIdByLoginAndPassword(String mail, String password) {
		return companyService.getIdByLoginAndPassword(mail, password);
	}

	public boolean isMailExist(String mail) {
		return companyService.isMailExist(mail);
	}

	public boolean isCodeExist(String code) {
		return companyService.isCodeExist(code);
	}

	public Company getCompanyById(int id) {
		return companyService.getCompanyById(id);
	}

	// company

	// recomendation
	public List<Recomendation> getRecomendationsByCompanyId(int companyid, String rate) {
		return recomendationService.getRecomendationsByCompanyId(companyid, rate);
	}
	
	public int getNumberOfGoodRecomendationByCompanyId(int companyid) {
		return recomendationService.getNumberOfRecomendationByCompanyId(
				companyid, "good");
	}

	public int getNumberOfBadRecomendationByCompanyId(int companyid) {
		return recomendationService.getNumberOfRecomendationByCompanyId(
				companyid, "bad");
	}
	
	public void addRecommendation(int dealid, int companyid, int companytenderid, int companytransportationid, String companytender, String companyproposition, String dealdate, String recomendationdate, String incoterms, String countryfrom, String countryto, int weight, String transport, String rate, String whyinfo){
		recomendationService.addRecommendation(dealid, companyid, companytenderid, companytransportationid, companytender, companyproposition, dealdate, recomendationdate, incoterms, countryfrom, countryto, weight, transport, rate, whyinfo);
	}
	
	public Recomendation getRecomendationByDealId(int dealid) {
		return recomendationService.getRecomendationByDealId(dealid);
	}
	
	public boolean isRecomendationExist(int dealid){
		try{
			Recomendation recomendation = getRecomendationByDealId(dealid);
			return true;
			}catch(NoResultException resultException){
				return false;
			}
	}


	// recomendation

	// test

	public List<Statistic> getAllStatistic() {
		return statisticService.getAllStatistics();
	}

	// test
}
