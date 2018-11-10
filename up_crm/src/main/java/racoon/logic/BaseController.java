package racoon.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import racoon.model.Client;
import racoon.model.Proposition;
import racoon.model.Request;
import racoon.service.ClientService;
import racoon.service.PropositionService;
import racoon.service.RequestService;


public class BaseController {
	
	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");
	
	public void addRequest(Request request){
		RequestService requestService = (RequestService) ctx
				.getBean("requestService");
		requestService.addRequest(request);
	}
	
	public void addProposition(Proposition proposition){
		PropositionService propositionService = (PropositionService) ctx
				.getBean("propositionService");
		propositionService.addProposition(proposition);
	}
	
	public List<String> getAllClientsByManager(String manager){
		ClientService clientService = (ClientService) ctx
				.getBean("clientService");
		List<Client> clients = clientService.getAllClientsByManager(manager);
		List<String> companies = new ArrayList();
		
		for(Client client:clients){
			companies.add(client.getCompany());
		}
		
		Collections.sort(companies);
		
		return companies;
	}
	
	public List<Client> getClientsByManager(String manager){
		ClientService clientService = (ClientService) ctx
				.getBean("clientService");
		return clientService.getAllClientsByManager(manager);
	}
	
	public Request getRequestById(int id) {
		RequestService requestService = (RequestService) ctx
				.getBean("requestService");
		return requestService.getRequestById(id);
	}
	
	public List<Proposition> getAllPropositionsByRequest(int idRequest) {
		PropositionService propositionService = (PropositionService) ctx
				.getBean("propositionService");
		return propositionService.getAllPropositionsByRequest(idRequest);
	}
	
	public void deleteProposition(int id){
		PropositionService propositionService = (PropositionService) ctx
				.getBean("propositionService");
		propositionService.deleteProposition(id);	
	}

	public void confirmProposition(int propositionId, int requestId) {
		
		PropositionService propositionService = (PropositionService) ctx
				.getBean("propositionService");
		List <Proposition> propositions = propositionService.getAllPropositionsByRequest(requestId);
		Constants desigion = new Constants();
		
		for(Proposition deal:propositions){
			if(deal.getId()==propositionId){
				propositionService.desideProposition(deal.getId(), desigion.RESULT_BOOKING);
			}else{
				propositionService.desideProposition(deal.getId(), desigion.RESULT_NOT_INTERESTING);
			}
		}
		RequestService requestService = (RequestService) ctx
				.getBean("requestService");
		requestService.setResultRequest(requestId, desigion.RESULT_BOOKING);
		
		
	}

	public void cancelProposition(int requestId) {
		
		PropositionService propositionService = (PropositionService) ctx
				.getBean("propositionService");
		List <Proposition> propositions = propositionService.getAllPropositionsByRequest(requestId);
		Constants desigion = new Constants();
		
		for(Proposition deal:propositions){
				propositionService.desideProposition(deal.getId(), desigion.RESULT_NOT_INTERESTING);		
		}
		RequestService requestService = (RequestService) ctx
				.getBean("requestService");
		requestService.setResultRequest(requestId, desigion.RESULT_NOT_INTERESTING);
		
	}
	

}
