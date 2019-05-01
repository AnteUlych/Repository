package lotos.logic;

import java.util.List;

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
	//company
	
	//test	
	public List<Deal> getAllDeals() {
		return dealService.getAllDeals();
	}
	
	public List<Proposition> getAllPropositions() {
		return propositionService.getAllPropositions();
	}
	
	public List<Recomendation> getAllRecomendations() {
		return recomendationService.getAllRecomendations();
	}
	
	public List<Statistic> getAllStatistic() {
		return statisticService.getAllStatistics();
	}
	
	public List<Tender> getAllTenders() {
		return tenderService.getAllTenders();
	}
	
	//test
}
