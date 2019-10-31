package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.AuctionDAO;
import box.model.Auction;


@Service("AuctionService")
@Transactional
public class AuctionService {
	
	@Autowired
	private AuctionDAO dao;
	
	public void addAuction(Auction auction) {
		dao.persist(auction);
	}
	
	public List<Auction> getListOfAuctionsByDirection(String direction) {
		return dao.getListOfAuctionsByDirection(direction);
	}
	
	public Auction getAuctionByAuctionId(int id){
		return dao.getAuctionByAuctionId(id);
	}
	
	public void editBetcountOfAuction(int id, int betcount) {
		dao.editBetcountOfAuction(id, betcount);
	}
	
	public void editImportanceOfAuction(int id, int importance) {
		dao.editImportanceOfAuction(id, importance);
	}
	
	public void deleteAuction(int id) {
		dao.deleteAuction(id);
	}

}
