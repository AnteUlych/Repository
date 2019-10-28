package box.logic;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import box.model.Auction;
import box.model.Manager;
import box.service.AuctionService;
import box.service.ManagerService;


public class DataBaseController {
	
	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");

	ManagerService managerService = (ManagerService) ctx
			.getBean("managerService");
	AuctionService auctionService = (AuctionService) ctx
			.getBean("auctionService");
	
	
	public void closeConnection() {
		((AbstractApplicationContext) ctx).close();
	}
	
	//login
	public Manager getManagersByCode(String code) {
		return managerService.getManagersByCode(code);
	}
	
	public boolean isCodeOfManagerExist(String code){
		return managerService.isCodeOfManagerExist(code);
	}
	//login
	
	//auction
	
	public void addAuction(Auction auction) {
		auctionService.addAuction(auction);
	}
	
	public List<Auction> getListOfAuctionsByDirection(String direction) {
		return auctionService.getListOfAuctionsByDirection(direction);
	}
	
	//auction

}
