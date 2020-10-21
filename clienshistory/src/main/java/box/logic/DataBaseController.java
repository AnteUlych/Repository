package box.logic;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import box.model.Manager;
import box.model.Product;
import box.service.ManagerService;
import box.service.ProductService;

public class DataBaseController {
	
	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");
	
	ManagerService managerService = (ManagerService) ctx
			.getBean("managerService");
	ProductService productService = (ProductService) ctx
			.getBean("productService");
	
	public void closeConnection() {
		((AbstractApplicationContext) ctx).close();
	}
	
	public List<Manager> getListOfManagers() {
		return managerService.getListOfManagers();
	}
	
	public List<Product> getListOfProducts(){
		return productService.getListOfProducts();
	}

}
