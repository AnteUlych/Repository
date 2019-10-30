package box.logic;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import box.model.Auction;
import box.model.Bet;
import box.model.Manager;
import box.model.Sold;
import box.service.AuctionService;
import box.service.BetService;
import box.service.ManagerService;
import box.service.SoldService;


public class DataBaseController {
	
	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");

	ManagerService managerService = (ManagerService) ctx
			.getBean("managerService");
	AuctionService auctionService = (AuctionService) ctx
			.getBean("auctionService");
	SoldService soldService = (SoldService) ctx
			.getBean("soldService");
	BetService betService = (BetService) ctx
			.getBean("betService");
	
	
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
	
	public int getNumberOfSoldByManagerId(int managerid) {
		return soldService.getNumberOfSoldByManagerId(managerid);
	}
	
	//auction
	
	//bets
	
	public Auction getAuctionByAuctionId(int id){
		return auctionService.getAuctionByAuctionId(id);
	}
	
	public void editBetcountOfAuction(int id, int betcount) {
		auctionService.editBetcountOfAuction(id, betcount);
	}
	
	public void editImportanceOfAuction(int id, int importance) {
		auctionService.editImportanceOfAuction(id, importance);
	}
	
	public void addSold(Sold sold){
		soldService.addSold(sold);
	}
	
	public List<Bet> getListOfBetsByAuctionId(int auctionid) {
		return betService.getListOfBetsByAuctionId(auctionid);
	}
	
	public void addBet(Bet bet) {
		betService.addBet(bet);
	}
	
	public void deleteBet(int id) {
		betService.deleteBet(id);
	}
	
	//bets
	
	

}