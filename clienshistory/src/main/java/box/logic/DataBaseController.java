package box.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import box.model.Calculates;
import box.model.Client;
import box.model.Manager;
import box.model.Product;
import box.model.Records;
import box.model.Weeklyreminder;
import box.service.CalculatesService;
import box.service.ClientService;
import box.service.ManagerService;
import box.service.ProductService;
import box.service.RecordsService;
import box.service.WeeklyreminderService;

public class DataBaseController {

	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");

	ManagerService managerService = (ManagerService) ctx
			.getBean("managerService");
	ProductService productService = (ProductService) ctx
			.getBean("productService");
	ClientService clientService = (ClientService) ctx.getBean("clientService");
	RecordsService recordsService = (RecordsService) ctx
			.getBean("recordsService");
	CalculatesService calculatesService = (CalculatesService) ctx
			.getBean("calculatesService");
	WeeklyreminderService weeklyreminderService = (WeeklyreminderService) ctx
			.getBean("weeklyreminderService");

	

	public void closeConnection() {
		((AbstractApplicationContext) ctx).close();
	}
	
	
	//Weeklyreminder
	
	public void editWeeklyreminderCheckById(int id, int isitnotchecked) {
		weeklyreminderService.editWeeklyreminderCheckById(id, isitnotchecked);
	}
	
	public List<Weeklyreminder> getListOfWeeklyreminderByClientid(int clientid) {
		return weeklyreminderService.getListOfWeeklyreminderByClientid(clientid);
	}
		
	public void addWeeklyReminder(Weeklyreminder weeklyreminder) {
		weeklyreminderService.addWeeklyReminder(weeklyreminder);
	}
	
	public List<Weeklyreminder> getListOfWeeklyreminderByManagerId(int managerid) {
		return weeklyreminderService.getListOfWeeklyreminderByManagerId(managerid);
	}
	
	public List<Weeklyreminder> getListOfUncheckedWeeklyreminderByManagerIdAndDayofweek(int managerid, int dayofweek) {
		return weeklyreminderService.getListOfUncheckedWeeklyreminderByManagerIdAndDayofweek(managerid, dayofweek);
	}
	
	public void deleteWeeklyreminderById(int id) {
		weeklyreminderService.deleteWeeklyreminderById(id);
	}
	
	public void editWeeklyreminderById(int id, String color, int isitnotchecked, Date bobdate) {
		weeklyreminderService.editWeeklyreminderById(id, color, isitnotchecked, bobdate);
	}
	
	public int getNumberOfUncheckedWeeklyreminderByManagerIdAndDayofweek(int managerid, int dayofweek) {
		return weeklyreminderService.getNumberOfUncheckedWeeklyreminderByManagerIdAndDayofweek(managerid, dayofweek);
	}
	

	// Calculates
	public List<Calculates> getListOfCalculatesByCompanyid(int companyid) {
		return calculatesService.getListOfCalculatesByCompanyid(companyid);
	}
	
	public List<Calculates> getListOfCalculatesBetweenDatesByManagerId(
			String start, String finish, int managerid){
        return calculatesService.getListOfCalculatesBetweenDatesByManagerId(start, finish, managerid);	
    }
	
	public List<Calculates> getListOfCalculates() {
		return calculatesService.getListOfCalculates();
	}

	public List<Calculates> getListOfCalculatesByManagerid(int managerid) {
	    return 	calculatesService.getListOfCalculatesByManagerid(managerid);
	}
	
	public void addCalculates(Calculates calculates) {
		calculatesService.addCalculates(calculates);
	}

	public List<Calculates> getListOfCalculatesFromDate(String startDate) {
		return calculatesService.getListOfCalculatesFromDate(startDate);
	}

	public List<Calculates> getListOfCalculatesFromDateByManagerId(
			String startDate, int managerid) {
		return calculatesService.getListOfCalculatesFromDateByManagerId(
				startDate, managerid);
	}
	
	public Calculates getCalculatesById(int id){
		return calculatesService.getCalculatesById(id);
	}

	public void editCalculatesById(int id, String budget, String cityfrom,
			String cityto, String comments, String company, int companyid,
			String countryfrom, String countryto, String dangerous, String calculateonadate,
			String exportimport, String freight, String rate,
			String temperature, String truck, int weight) {
		calculatesService.editCalculatesById(id, budget, cityfrom, cityto,
				comments, company, companyid, countryfrom, countryto,
				dangerous, calculateonadate,
				exportimport, freight, rate, temperature, truck, weight);
	}

	// Manager
	public boolean isManagerExisByCode(String code) {
		return managerService.isManagerExisByCode(code);
	}

	public Manager getManagersByCode(String code) {
		return managerService.getManagersByCode(code);
	}

	public List<Manager> getListOfManagers() {
		return managerService.getListOfManagers();
	}

	public List<Manager> getListOfNotAdminManagers() {
		return managerService.getListOfNotAdminManagers();
	}

	public Manager getManagerById(int id) {
		return managerService.getManagerById(id);
	}

	public void firedManagerById(int id) {
		managerService.firedManagerById(id);
	}

	public void deleteManager(int id) {
		managerService.deleteManager(id);
	}

	public void addManager(Manager manager) {
		managerService.addManager(manager);
	}

	public String generateCodeForManager() {

		String code;

		for (;;) {

			int min = 10000;
			int max = 99999;

			Random random = new Random();
			int i = random.nextInt((max - min) + 1) + min;
			code = i + "";

			if (!managerService.isManagerExisByCode(code)) {
				return code;
			}
		}

	}

	public void editManagerById(int id, String name, String mail, String code,
			int rank) {
		managerService.editManagerById(id, name, mail, code, rank);
	}

	// Manager

	// Client
	public void editClientById(int id, int funel, String company, String edrpo,
			String freight, String lpr, String mail, String manager,
			int managerid, String mobile, String othercontact, String phone,
			String products) {
		clientService
				.editClientById(id, funel, company, edrpo, freight, lpr, mail,
						manager, managerid, mobile, othercontact, phone,
						products);
	}

	public void editNectcallAndLastrecordAndFunekOfClientById(int id,
			Date nextcall, int funel, String lastrecord) {
		clientService.editNectcallAndLastrecordAndFunekOfClientById(id,
				nextcall, funel, lastrecord);
	}

	public void addClient(Client client) {
		clientService.addClient(client);
	}

	public List<Client> getClientsByManagerIdSortedByNexcall(int managerid) {
		return clientService.getClientsByManagerIdSortedByNexcall(managerid);
	}

	public List<Client> getClientsSortedByNextcall() {
		return clientService.getClientsSortedByNextcall();
	}

	public List<Client> getClientsByCodeOrCompany(String word) {
		List<Client> allClients = clientService.getListOfClients();
		List<Client> filtrClients = new ArrayList();

		for (Client client : allClients) {
			if (client.getCompany().toLowerCase().contains(word.toLowerCase())
					|| client.getEdrpo().contains(word)) {
				filtrClients.add(client);
			}
		}

		return filtrClients;
	}

	public List<Client> getClientsByManagerIdAndProductSortedByNexcall(
			int managerid, String product) {

		List<Client> clients = clientService
				.getClientsByManagerIdSortedByNexcall(managerid);
		List<Client> productClients = new ArrayList();

		for (Client c : clients) {
			if (c.getProducts().contains(product)) {
				productClients.add(c);
			}
		}

		return productClients;
	}

	public List<Client> getClientsByProductSortedByNextcall(String product) {
		List<Client> clients = clientService.getClientsSortedByNextcall();
		List<Client> productClients = new ArrayList();

		for (Client c : clients) {
			if (c.getProducts().contains(product)) {
				productClients.add(c);
			}
		}

		return productClients;
	}

	public boolean isEDRPOExist(String edrpo) {
		List<Client> clients = clientService.getListOfClients();

		for (Client client : clients) {
			if (client.getEdrpo().equals(edrpo)) {
				return true;
			}
		}

		return false;
	}

	public Client getClientByERDPO(String edrpo) {
		return clientService.getClientByERDPO(edrpo);
	}

	public Client getClientById(int id) {
		return clientService.getClientById(id);
	}

	public int getNumberOfClientsByManagerid(int managerid) {
		return clientService.getNumberOfClientsByManagerid(managerid);
	}

	public List<Client> getClientsByFunelAndOpenProduct(int funel,
			String product) {
		return clientService.getClientsByFunelAndOpenProduct(funel, product);
	}

	public List<Client> getClientsByManagerIdBetweenDates(int managerid,
			String start, String finish) {
		return clientService.getClientsByManagerIdBetweenDates(managerid,
				start, finish);
	}
	
	public List<Client> getClientsSortedByName() {
		return clientService.getClientsSortedByName();
	}

	// Client

	// Product
	public List<Product> getListOfOpenProducts() {
		return productService.getListOfOpenProducts();
	}

	public Product getProductById(int productid) {
		return productService.getProductById(productid);
	}

	public void addProduct(Product product) {
		productService.addProduct(product);
	}

	public void hideProduct(int id) {
		productService.hideProduct(id);
	}

	public void openProduct(int id) {
		productService.openProduct(id);
	}

	public List<Product> getListOfProducts() {
		return productService.getListOfProducts();
	}

	public boolean isProductsExis(String product) {
		return productService.isProductsExis(product);
	}

	// Product

	// Records
	public void addRecords(Records record) {
		recordsService.addRecords(record);
	}

	public List<Records> getListOfRecordsByClientId(int clientid) {
		return recordsService.getListOfRecordsByClientId(clientid);
	}

	public List<Records> getListOfRecordsByManagerIdIdAndStatusBetweenDates(
			int managerid, int recordstatus, String start, String finish) {
		return recordsService
				.getListOfRecordsByManagerIdIdAndStatusBetweenDates(managerid,
						recordstatus, start, finish);
	}

	public List<Records> getListOfRecordsByManagerIdsBetweenDates(
			int managerid, String start, String finish) {
		return recordsService.getListOfRecordsByManagerIdsBetweenDates(
				managerid, start, finish);
	}

}
