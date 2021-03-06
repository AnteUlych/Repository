package racoon.logic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.NoResultException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import racoon.model.Client;
import racoon.model.Manager;
import racoon.model.Proposition;
import racoon.model.Request;
import racoon.model.Status;
import racoon.service.ClientService;
import racoon.service.ManagerService;
import racoon.service.PropositionService;
import racoon.service.RequestService;
import racoon.service.StatusService;

public class BaseController {

	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");
	ClientService clientService = (ClientService) ctx.getBean("clientService");
	StatusService statusService = (StatusService) ctx.getBean("statusService");
	RequestService requestService = (RequestService) ctx
			.getBean("requestService");
	PropositionService propositionService = (PropositionService) ctx
			.getBean("propositionService");
	ManagerService managerService = (ManagerService) ctx
			.getBean("managerService");

	// 22.11
	public void closeConnection() {
		((AbstractApplicationContext) ctx).close();
	}

	// 22.11
	
	public int getManagerIdByName(String name) {
		return managerService.getManagerIdByName(name);
	}
	
	public void addManager(Manager manager) {
		managerService.addManager(manager);
	}
	
	public void firedManager(int id, String firedManager) {
		managerService.firedManager(id, firedManager);
	}
	
	public void editManagerOfClient(int id, String manager) {
		clientService.editManagerOfClient(id, manager);
	}
	
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}
	

	public Client getClientById(int id) {
		return clientService.getClientById(id);
	}
	
	public List<String> getDatesForClientsInNormalFormat(List<Client> clients){
		List<String> dates = new ArrayList();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		//String reportDate = df.format(today);
		for(Client c:clients){
			dates.add(df.format(c.getNextcall()));
		}
		
		return dates;
	}
	//number request for report2
	public int getNumberOfAllRequestsByCompanyBetweenDates(String company, String start, String ending) {
		return requestService.getAllRequestsByCompanyBetweenDates(company, start, ending).size();
	}
	//number bookings for report2
	public int getNumberOfAllBookingRequestsByCompanyBetweenDates(String company, String start, String ending) {
		
		List<Request> requests = requestService.getAllRequestsByCompanyBetweenDates(company, start, ending);
		
		int bookings = 0;
		
		for(Request request:requests){
			if(request.getResult().equals("booking")){
				bookings++;
			}
		}
		return bookings;
	}
	//report2 all parter clients
	public List<Client> getAllClientsByFunnel(String funnel) {
		return clientService.getAllClientsByFunnel(funnel);
	}
	
	public List<Proposition> getAllPropositionsByManagerTypeAndDates(String start, String ending, String manager, String result) {
		return propositionService.getAllPropositionsByManagerTypeAndDates(start, ending, manager, result);
	}
	//report1 number of propositions with result
	public int getNumberOfAllPropositionsByManagerTypeAndDates(String start, String ending, String manager, String result) {
		return propositionService.getAllPropositionsByManagerTypeAndDates(start, ending, manager, result).size();
	}
	
	public List<Proposition> getAllPropositionsByTypeAndDates(String start, String ending, String result) {
		return propositionService.getAllPropositionsByTypeAndDates(start, ending, result);
	}
	//report1 number of proposition
	public int getNumberOfAllPropositionsByTypeAndDates(String start, String ending, String result) {
		return propositionService.getAllPropositionsByTypeAndDates(start, ending, result).size();
	}
	
	public int getNumberOfAllRequestsByManagerTypeBetweenDates(String manager, String type, String start, String ending){
		return requestService.getAllRequestsByManagerTypeBetweenDates(manager, type, start, ending).size();
	}
	
	public List<Request> getAllRequestsByManagerTypeResultsBetweenDates(String manager, String type, String result, String start, String ending) {
		return requestService.getAllRequestsByManagerTypeResultsBetweenDates(manager, type, result, start, ending);		 
	}
	//report1 all statistic
	public int getNumberOfAllRequestsByManagerTypeResultsBetweenDates(String manager, String type, String result, String start, String ending) {
		return requestService.getAllRequestsByManagerTypeResultsBetweenDates(manager, type, result, start, ending).size();		 
	}
	
	public List<Request> getAllRequestsByTypeResultsBetweenDates(String type, String result, String start, String ending) {
		return requestService.getAllRequestsByTypeResultsBetweenDates(type, result, start, ending);		 
	}
	//report1 for Total
	public int getNumberOfAllRequestsByTypeResultsBetweenDates(String type, String result, String start, String ending) {
		return requestService.getAllRequestsByTypeResultsBetweenDates(type, result, start, ending).size();		 
	}
    //all managers
	public List<Manager> getAllManagers() {
		return managerService.getAllManagers();
	}
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

	public void startTradeForRequest(int requestId, String status) {
		Constants constant = new Constants();
		requestService.setResultRequest(requestId, constant.RESULT_WAITING);
	}

	public void cancelProposition(int requestId, String answer) {

		List<Proposition> propositions = propositionService
				.getAllPropositionsByRequest(requestId);
		Constants desigion = new Constants();

		for (Proposition deal : propositions) {
			propositionService.desideProposition(deal.getId(),
					desigion.RESULT_NOT_INTERESTING);
		}
		if (answer.equals("")) {
			answer = desigion.RESULT_NOT_INTERESTING;
		}
		requestService.setResultRequest(requestId, answer);

	}

	// from here new

	public List<String> getTableTaboo(List<Proposition> proposition,
			String manager) {

		List<String> taboo = new ArrayList();

		for (Proposition propose : proposition) {
			if (propose.getManager().equals(manager)) {
				taboo.add("");
			} else {
				taboo.add("disabled");
			}
		}
		return taboo;
	}

	public List<String> getTableColour(List<Request> requests) {

		List<String> colours = new ArrayList();
		Constants constant = new Constants();

		for (Request request : requests) {
			if (request.getResult().equals(constant.RESULT_BOOKING)) {
				colours.add("w3-green");
			} else if (request.getResult().equals(constant.RESULT_EMPTY)) {
				colours.add("w3-yellow");
			} else if (request.getResult().equals(constant.RESULT_WAITING)) {
				colours.add("");
			} else {
				colours.add("w3-red");
			}
		}
		return colours;
	}

	public Date makeStringtoDate(String date) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getIdOfManagerFromRequestsPage(String code) {

		String separateCode[] = code.split("_");

		int daysCode = Integer.parseInt(separateCode[0]);

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int trueDay = c.get(Calendar.DAY_OF_WEEK);

		if (daysCode != trueDay) {
			return 0;
		}

		return Integer.parseInt(separateCode[1]);
	}

	public int getIdOfRequestFromRequestsPage(String code) {
		String separateCode[] = code.split("_");

		int daysCode = Integer.parseInt(separateCode[0]);

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int trueDay = c.get(Calendar.DAY_OF_WEEK);

		if (daysCode != trueDay) {
			return 0;
		}

		return Integer.parseInt(separateCode[2]);
	}

	public int todayDay() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return c.get(Calendar.DAY_OF_WEEK);
	}

	public String encodeServiceCode(String code) {

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();
		for (String changes : services) {
			code = code.replace(changes, "");
		}

		return code;
	}

	public Manager getFullInfoByManagerByCode(String code) {

		String firstPart = code.substring(0, 1);
		String secondPart = code.substring(1, 5);

		int daysCode = Integer.parseInt(firstPart);

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int trueDay = c.get(Calendar.DAY_OF_WEEK);

		if (daysCode != trueDay) {
			return null;
		}

		int managerCode = Integer.parseInt(secondPart);
		Manager manager;
		try {
			manager = managerService.getManagersByCode(managerCode);

		} catch (NoResultException e) {
			return null;
		}
		return manager;
	}

	public String getManagerMailById(int id) {
		return managerService.getManagersMailById(id);
	}
	public String getManagersMailByName(String name) {
		return managerService.getManagersMailByName(name);
	}

	public List<Request> getRequestsByServiceFromCodeConsole(String code) {

		String firstPart = code.substring(0, 1);
		String deleteCode = code.substring(0, 5);

		int daysCode = Integer.parseInt(firstPart);

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int trueDay = c.get(Calendar.DAY_OF_WEEK);

		if (daysCode != trueDay) {
			return null;
		}

		String type = code.replaceAll(deleteCode, "");
		return requestService.getAllRequestsByType(type);
	}

	public Client getClientByIdCodeFromConsole(String code) {

		ClientService clientService = (ClientService) ctx
				.getBean("clientService");

		String firstPart = code.substring(0, 1);
		String deleteCode = code.substring(0, 5);

		int id = Integer.parseInt(code.replaceAll(deleteCode, ""));

		int daysCode = Integer.parseInt(firstPart);

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int trueDay = c.get(Calendar.DAY_OF_WEEK);

		if (daysCode != trueDay) {
			return null;
		}

		return clientService.getClientById(id);

	}

	public String getAccess(String password) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			int trueDay = c.get(Calendar.DAY_OF_WEEK);
			try {
				String manager = getManagerByCode(trueDay + password);
				return manager;
			} catch (NoResultException e) {
				return "denied";
			}
		} catch (Exception e1) {
			return "denied";
		}

	}

	public String encode(String code) {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int trueDay = c.get(Calendar.DAY_OF_WEEK);
		String firstPartofCode = trueDay + "";
		String encode = firstPartofCode + code;

		return encode;
	}

	public String getPasswordById(int id) {

		int password = managerService.getManagersPasswordByCode(id);
		String code = password + "";
		return code;
	}

	public String getCodePasswordById(int id) {

		int password = managerService.getManagersPasswordByCode(id);
		String encode = encode(password + "");
		return encode;
	}

	public String getManagerNameById(int id) {
		String name = managerService.getManagersNameById(id);
		return name;
	}

	public String getManagerByCode(String code) {

		String result = "denied";

		String firstPart = code.substring(0, 1);
		String secondPart = code.substring(1, 5);

		int daysCode = Integer.parseInt(firstPart);

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int trueDay = c.get(Calendar.DAY_OF_WEEK);

		if (daysCode != trueDay) {
			return result;
		}

		int managerCode = Integer.parseInt(secondPart);
		Manager manager;
		try {
			manager = managerService.getManagersByCode(managerCode);
			result = manager.getName();
		} catch (NoResultException e) {
			return result;
		}
		return result;
	}

	public int giveCodeToManger() {

		Random random = new Random();
		int code;

		for (;;) {

			code = 1000 + random.nextInt(9999 - 1000);
			
			try {
				Manager manager = managerService.getManagersByCode(code);
			} catch (NoResultException e) {
				return code;
			}

		}

	}

	public boolean isCodeCompanyExist(String cod) {
		try {

			Client client = clientService.getClientByCode(cod);
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
	// to here new

}
