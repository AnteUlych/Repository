package box.logic;

import java.util.List;
import java.util.Random;

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
	
	//deal
	
	public void editArchivebetById(int id, String status) {
		archivebetService.editArchivebetById(id, status);
	}
	
	public List<Deal> getListOfallDeals() {
		return dealService.getListOfallDeals();
	}
	
	public List<Deal> getListOfallDealsByDirection(String direction) {
		return dealService.getListOfallDealsByDirection(direction);
	}
	
	public List<Deal> getListOfallDealsByManagerId(int managerid) {	
		return dealService.getListOfallDealsByManagerId(managerid);
	}
	
	public List<Deal> getListOfallDealsByManagerIdAndDirection(int managerid, String direction) {
		return dealService.getListOfallDealsByManagerIdAndDirection(managerid, direction);
	}
	
	public Deal getDealById(int id) {
		return dealService.getDealById(id);
	}
	
	public void editTruckdriverById(int id, String truckdriver) {
		dealService.editTruckdriverById(id, truckdriver);
	}

	public void editStatusOfDealById(int id, String status) {
		dealService.editStatusOfDealById(id, status);
	}
	
	public Archivebet getArchivebetByBetid(int betid) {
		return archivebetService.getArchivebetByBetid(betid);
	}
	
	public void editOtherinformationOfDealById(int id, String otherinformation) {
		dealService.editOtherinformationOfDealById(id, otherinformation);
	}
	
	//deal
	
	//manager
	
	public void addManager(Manager manager){
		managerService.addManager(manager);
	}
	
	public List<Manager> getListOfManagers() {
		return managerService.getListOfManagers();
	}
	
	public void editManager(int id, String name, String mail, String rank, String code) {
		managerService.editManager(id, name, mail, rank, code);
	}
	
	public Manager getManagerById(int id) {
		return managerService.getManagerById(id);
	}
	
	public String generateCodeForManager(){
		
		String code;
				
		for(;;){
			
			int min = 10000;
			int max = 99999;
	
			Random random = new Random();
			int i = random.nextInt((max-min)+1)+ min;
			code = i+"";
			
			if(!isCodeExist(code)){
				return code;
			}
		}
		
	}
	
	public boolean isCodeExist(String code){
		List<Manager> managers = managerService.getListOfManagers();
		
		for(Manager m:managers){
			if(code.equals(m.getCode())){
				return true;
			}
			
		}
		
		return false;
	}
	
	//manager
	
	//report
	
	public List<Manager> getListOfManagersByRank(String rank) {
		return managerService.getListOfManagersByRank(rank);
	}
	
	public int getNumberOfArchivebetByManagerIdDates(String start, String ending, int managerid) {
		return archivebetService.getNumberOfArchivebetByManagerIdDates(start, ending, managerid);
	}
	
	public int getNumberOfArchivebetByManagerIdAndStatusDates(String start, String ending, int managerid, String status) {
		return archivebetService.getNumberOfArchivebetByManagerIdAndStatusDates(start, ending, managerid, status);
	}

	public int getSummOfArchivebetByManagerIdAndStatusDates(String start, String ending, int managerid, String status, String currency) {
		return archivebetService.getSummOfArchivebetByManagerIdAndStatusDates(start, ending, managerid, status, currency);
	}
	
	public int getNumberOfArchiveauctionDates(String start, String ending) {
		return archiveauctionService.getNumberOfArchiveauctionDates(start, ending);
	}
	
	public List<Archiveauction> getListOfArchiveauctionDates(String start, String ending) {
		return archiveauctionService.getListOfArchiveauctionDates(start, ending);
	}
	
	public List<Archivebet> getListOfArchivebetsByAuctionId(int auctionid) {
		return archivebetService.getListOfArchivebetsByAuctionId(auctionid);
	}
	
	public Archiveauction getArchiveauctionByAuctionId(int auctionid){
		return archiveauctionService.getArchiveauctionByAuctionId(auctionid);
	}
	
	//report

}
