package box.logic;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import box.model.Archiveauction;
import box.model.Archivebet;
import box.model.Auction;
import box.model.Bet;
import box.model.Deal;
import box.model.Manager;
import box.model.Sold;
import box.service.ArchiveauctionService;
import box.service.ArchivebetService;
import box.service.AuctionService;
import box.service.BetService;
import box.service.DealService;
import box.service.ManagerService;
import box.service.SoldService;


public class DataBaseController {
	
	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");

	ManagerService managerService = (ManagerService) ctx
			.getBean("managerService");
	AuctionService auctionService = (AuctionService) ctx
			.getBean("auctionService");
	BetService betService = (BetService) ctx
			.getBean("betService");
	SoldService soldService = (SoldService) ctx
			.getBean("soldService");
	ArchiveauctionService archiveauctionService = (ArchiveauctionService) ctx
			.getBean("archiveauctionService");
	ArchivebetService archivebetService = (ArchivebetService) ctx
			.getBean("archivebetService");
	DealService dealService = (DealService) ctx
			.getBean("dealService");
	
	
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
	
	public void editStatusOfBet(int id, String status) {
		betService.editStatusOfBet(id, status);
	}
	
	public void addArchiveauction(Archiveauction archiveauction) {
		archiveauctionService.addArchiveauction(archiveauction);
	}
	
	public void addArchivebet(Archivebet archivebet) {
		archivebetService.addArchivebet(archivebet);
	}
	
	public void deleteAuction(int id) {
		auctionService.deleteAuction(id);
	}
	
	//bets
	
	//sold
	
	public List<Sold> getListOfSoldByManagerId(int managerid) {
		return soldService.getListOfSoldByManagerId(managerid);
	}
	
	public List<Sold> getListOfAllSold() {
		return soldService.getListOfAllSold();
	}
	
	public void deleteSold(int id) {
		soldService.deleteSold(id);
	}
	
	public void addDeal(Deal deal){
		dealService.addDeal(deal);
	}
	
	//sold
	
	

}
