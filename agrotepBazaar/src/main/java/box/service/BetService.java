package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.BetDAO;
import box.model.Bet;


@Service("BetService")
@Transactional
public class BetService {
	
	@Autowired
	private BetDAO dao;
	
	public List<Bet> getListOfBetsByAuctionId(int auctionid) {
		return dao.getListOfBetsByAuctionId(auctionid);
	}
	
	public void addBet(Bet bet) {
		dao.persist(bet);
	}
	
	public void deleteBet(int id) {
		dao.deleteBet(id);
	}
	
	public void editStatusOfBet(int id, String status) {
		dao.editStatusOfBet(id, status);
	}
	
	public Bet getBetbyId(int id){
		return dao.getBetbyId(id);
	}

}
