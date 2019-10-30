package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Auction;


@Repository
public class AuctionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Auction auction) {
		Auction transaction = em.merge(auction);
		em.persist(transaction);
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Auction> getListOfAuctionsByDirection(String direction) {
		return em.createQuery(
				"from Auction where direction = '" + direction + "' order by importance")
				.getResultList();
	}
	
	public Auction getAuctionByAuctionId(int id){
		Auction auction = (Auction) em.find(Auction.class, id);
		return auction;
	}
	
	@Transactional
	public void editBetcountOfAuction(int id, int betcount) {

		Auction auction = (Auction) em.find(Auction.class, id);

		auction.setBetcount(betcount);

		Auction transaction = em.merge(auction);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void editImportanceOfAuction(int id, int importance) {
		
		Auction auction = (Auction) em.find(Auction.class, id);

		auction.setImportance(importance);

		Auction transaction = em.merge(auction);
		em.persist(transaction);
		em.close();
		
	}
	

}
