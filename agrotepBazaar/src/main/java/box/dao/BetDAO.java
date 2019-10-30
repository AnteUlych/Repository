package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Bet;

@Repository
public class BetDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Bet> getListOfBetsByAuctionId(int auctionid) {
		return em.createQuery(
				"from Bet where auctionid = '" + auctionid + "' order by rate desc")
				.getResultList();
	}
	
	@Transactional
	public void persist(Bet bet) {
		Bet transaction = em.merge(bet);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void deleteBet(int id) {
		Bet bet = (Bet) em.find(Bet.class, id);
		Bet transaction = em.merge(bet);
		em.remove(transaction);
		em.close();
	}

}
