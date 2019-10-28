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

}
