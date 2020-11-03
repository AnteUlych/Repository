package box.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import box.model.Client;
import box.model.Manager;
import box.model.Product;
import box.model.Records;
import box.service.ClientService;
import box.service.ManagerService;
import box.service.ProductService;
import box.service.RecordsService;

public class DataBaseController {

	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");

	ManagerService managerService = (ManagerService) ctx
			.getBean("managerService");
	ProductService productService = (ProductService) ctx
			.getBean("productService");
	ClientService clientService = (ClientService) ctx.getBean("clientService");
	RecordsService recordsService = (RecordsService)ctx.getBean("recordsService");

	public void closeConnection() {
		((AbstractApplicationContext) ctx).close();
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
	
	public List<Manager> getListOfNotAdminManagers(){
		return managerService.getListOfNotAdminManagers();
	}

	// Manager

	// Client
	public void editClientById(int id, int funel, String company, String edrpo, String freight,
			String lpr, String mail, String manager, int managerid,
			String mobile, String othercontact, String phone, String  products){
		clientService.editClientById(id, funel, company, edrpo, freight, lpr, mail, manager, managerid, mobile, othercontact, phone, products);
	}
	
	public void editNectcallAndLastrecordAndFunekOfClientById(int id, Date nextcall, int funel, String lastrecord){
		clientService.editNectcallAndLastrecordAndFunekOfClientById(id, nextcall, funel, lastrecord);
	}
	
	public void addClient(Client client){
		clientService.addClient(client);
	}
	
	public List<Client> getClientsByManagerIdSortedByNexcall(int managerid) {
		return clientService.getClientsByManagerIdSortedByNexcall(managerid);
	}
	
	public List<Client> getClientsSortedByNextcall() {
		return clientService.getClientsSortedByNextcall();
	}
	
	public List<Client> getClientsByCodeOrCompany(String word){
		List<Client> allClients = clientService.getListOfClients();
		List<Client> filtrClients = new ArrayList();
		
		for(Client client:allClients){
			if(client.getCompany().toLowerCase().contains(word.toLowerCase())||client.getEdrpo().contains(word)){
				filtrClients.add(client);
			}
		}
		
		return filtrClients;
	}
	
	public List<Client> getClientsByManagerIdAndProductSortedByNexcall(int managerid, String product) {
		
		 List<Client> clients = clientService.getClientsByManagerIdSortedByNexcall(managerid);
		 List<Client> productClients = new ArrayList();
		 
		 for(Client c:clients){
			 if(c.getProducts().contains(product)){
				 productClients.add(c);
			 }
		 }
		 
		 return productClients;
	}
	
	public List<Client> getClientsByProductSortedByNextcall(String product) {
		List<Client> clients = clientService.getClientsSortedByNextcall();
		 List<Client> productClients = new ArrayList();
		 
		 for(Client c:clients){
			 if(c.getProducts().contains(product)){
				 productClients.add(c);
			 }
		 }
		 
		 return productClients;
	}
	
	public boolean isEDRPOExist(String edrpo){
		List<Client> clients = clientService.getListOfClients();
		
		for(Client client:clients){
			if(client.getEdrpo().equals(edrpo)){
				return true;
			}
		}
		
		return false;
	}
	
	public Client getClientByERDPO(String edrpo) {
		return clientService.getClientByERDPO(edrpo);
	}
	
	public Client getClientById(int id){
		return clientService.getClientById(id);
	}

	// Client

	//Product
	public List<Product> getListOfOpenProducts() {
		return productService.getListOfOpenProducts();
	}
	
	public Product getProductById(int productid){
		return productService.getProductById(productid);
	}
	//Product
	
	//Records
	public void addRecords(Records record){
		recordsService.addRecords(record);
	}
	
	public List<Records> getListOfRecordsByClientId(int clientid) {
		return recordsService.getListOfRecordsByClientId(clientid);
	}
	

}
