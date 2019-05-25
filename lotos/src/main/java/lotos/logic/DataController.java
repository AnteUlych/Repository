package lotos.logic;

import java.util.ArrayList;
import java.util.List;

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
	CompanyService companyService = (CompanyService) ctx.getBean("companyService");
	DealService dealService = (DealService) ctx.getBean("dealService");
	PropositionService propositionService = (PropositionService) ctx.getBean("propositionService");
	RecomendationService recomendationService = (RecomendationService) ctx.getBean("recomendationService");
	RequestService requestService = (RequestService) ctx.getBean("requestService");
	StatisticService statisticService = (StatisticService) ctx.getBean("statisticService");
	TenderService tenderService = (TenderService) ctx.getBean("tenderService");
	

	public void closeConnection() {
		((AbstractApplicationContext) ctx).close();
	}
	
	//deal
	
	
	public List<Deal> getDealsByCompanyOrPropositionId(int companytenderid, int companypropositionid) {
		return dealService.getDealsByCompanyOrPropositionId(companytenderid, companypropositionid);
	}
	
	public int getNumberofClosingDealsByCompanyId(int companytenderid) {
		return dealService.getNumberofClosingDealsByCompanyId(companytenderid);
	}
	
	public int getNumberWinningDealsByCompanyId(int companypropositionid) {
		return dealService.getNumberWinningDealsByCompanyId(companypropositionid);
	}
	
	//deal
	//proposition
	public List<Proposition> getPropositionsByTenderId(int tenderId) {
		return propositionService.getPropositionsByTenderId(tenderId);
	}
	
	public List<Proposition> getPropositionsByCompanyId(int companyId) {
		return propositionService.getPropositionsByCompanyId(companyId);
	}
	//proposition
	
	//tender
	public List<Tender> getOpenTenders() {
		return tenderService.getOpenTenders();
	}
	
	public List<Tender> getOpenTendersFiltr(int more, int less, String countryfrom, String countryto, String transport) {
		
		List<Tender> tenders = tenderService.getOpenTendersFiltr(more, less, countryfrom, countryto);
		
		if(transport.contains("any")){
			return tenders;
		}
		List<Tender> transportTenders = new ArrayList();
		for (Tender tender:tenders){
			if(tender.getPossibletransport().equals(transport)){
				transportTenders.add(tender);
			}
		}
		return transportTenders;
	} 
	
	public int getNumberOfTendersByCompanyId(int companyId) {
		return tenderService.getNumberOfTendersByCompanyId(companyId);
	}
	
	public List<Tender> getOpenTendersByCompanyId(int companyId){
		return tenderService.getOpenTendersByCompanyId(companyId);
	}
	//tender
	
	//request
	public void createNewRequest(Request request) {
		requestService.createNewRequest(request);
	}
	
	public boolean isMailInRequestExist(String mail){
		return requestService.isMailInRequestExist(mail);
	}
	
	public boolean isCodeInRequestExist(String code){
		return requestService.isCodeInRequestExist(code);
	}
	//request
	
	//company
	public int getIdByLoginAndPassword(String mail, String password) {
		return companyService.getIdByLoginAndPassword(mail, password);
	}
	
	public boolean isMailExist(String mail){
		return companyService.isMailExist(mail);
	}
	
	public boolean isCodeExist(String code){
		return companyService.isCodeExist(code);
	}
	
	public Company getCompanyById(int id) {
		return companyService.getCompanyById(id);
	}
	//company
	
	//recomendation
	public int getNumberOfGoodRecomendationByCompanyId(int companyid){
		return recomendationService.getNumberOfRecomendationByCompanyId(companyid, "good");
	}
	
	public int getNumberOfBadRecomendationByCompanyId(int companyid){
		return recomendationService.getNumberOfRecomendationByCompanyId(companyid, "bad");
	}
	//recomendation
	
	//test	
	
	public List<Statistic> getAllStatistic() {
		return statisticService.getAllStatistics();
	}
	
	//test
}
