package box.logic;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import box.model.Client;
import box.model.Manager;
import box.model.Product;
import box.service.ClientService;
import box.service.ManagerService;
import box.service.ProductService;

public class DataBaseController {

	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");

	ManagerService managerService = (ManagerService) ctx
			.getBean("managerService");
	ProductService productService = (ProductService) ctx
			.getBean("productService");
	ClientService clientService = (ClientService) ctx.getBean("clientService");

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
	public List<Client> getClientsByManagerIdSortedByNexcall(int managerid) {
		return clientService.getClientsByManagerIdSortedByNexcall(managerid);
	}
	
	public List<Client> getClientsSortedByNextcall() {
		return clientService.getClientsSortedByNextcall();
	}

	// Client

	//Product
	public List<Product> getListOfProducts() {
		return productService.getListOfProducts();
	}
	//Product

}
