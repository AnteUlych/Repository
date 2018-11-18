package racoon.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import racoon.model.Client;
import racoon.model.Proposition;
import racoon.model.Request;
import racoon.model.Status;
import racoon.service.ClientService;
import racoon.service.PropositionService;
import racoon.service.RequestService;
import racoon.service.StatusService;

public class BaseController {

	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");
	ClientService clientService = (ClientService) ctx
			.getBean("clientService");
	StatusService statusService = (StatusService) ctx
			.getBean("statusService");
	RequestService requestService = (RequestService) ctx
			.getBean("requestService");
	PropositionService propositionService = (PropositionService) ctx
			.getBean("propositionService");
	

	public Client getClientByCode(String code) {
		
		return clientService.getClientByCode(code);
	}

	public void addStatus(Status status) {
		
		statusService.addStatus(status);
	}

	public List<Status> getAllStatusByCompanyId(int clientId) {
	
		return statusService.getAllStatusByCompanyId(clientId);
	}

	public List<Request> getAllRequestsByCompany(String company) {
		
		return requestService.getAllRequestsByCompany(company);
	}

	public void addRequest(Request request) {
	
		requestService.addRequest(request);
	}

	public void addProposition(Proposition proposition) {
		
		propositionService.addProposition(proposition);
		
	}

	public void editClient(int id, String company, String phone, String person,
			String category, String mail) {
		
		clientService.editClient(id, company, phone, person, category, mail);
	}

	public void editClientStatus(int id, String answer, Date nextcall,
			String funnel) {
		
		clientService.editClientStatus(id, answer, nextcall, funnel);
	}

	public List<String> getAllClientsByManager(String manager) {
	
		List<Client> clients = clientService.getAllClientsByManager(manager);
		List<String> companies = new ArrayList();

		for (Client client : clients) {
			companies.add(client.getCompany());
		}

		Collections.sort(companies);

		return companies;
	}

	public List<Client> getClientsByManager(String manager) {
		
		return clientService.getAllClientsByManager(manager);
	}

	public void addClient(Client client) {
		
		clientService.addClient(client);
	}

	public Request getRequestById(int id) {
		
		return requestService.getRequestById(id);
	}

	public List<Proposition> getAllPropositionsByRequest(int idRequest) {
		
		return propositionService.getAllPropositionsByRequest(idRequest);
	}

	public void deleteProposition(int id) {
		
		propositionService.deleteProposition(id);
	}

	public void confirmProposition(int propositionId, int requestId) {

		List<Proposition> propositions = propositionService
				.getAllPropositionsByRequest(requestId);
		Constants desigion = new Constants();

		for (Proposition deal : propositions) {
			if (deal.getId() == propositionId) {
				propositionService.desideProposition(deal.getId(),
						desigion.RESULT_BOOKING);
			} else {
				propositionService.desideProposition(deal.getId(),
						desigion.RESULT_NOT_INTERESTING);
			}
		}
	
		requestService.setResultRequest(requestId, desigion.RESULT_BOOKING);

	}
	
	public void startTradeForRequest( int requestId, String status){
		Constants constant = new Constants();
		requestService.setResultRequest(requestId, constant.RESULT_WAITING);
	}

	public void cancelProposition(int requestId) {

		List<Proposition> propositions = propositionService
				.getAllPropositionsByRequest(requestId);
		Constants desigion = new Constants();

		for (Proposition deal : propositions) {
			propositionService.desideProposition(deal.getId(),
					desigion.RESULT_NOT_INTERESTING);
		}
	
		requestService.setResultRequest(requestId,
				desigion.RESULT_NOT_INTERESTING);

	}

}
