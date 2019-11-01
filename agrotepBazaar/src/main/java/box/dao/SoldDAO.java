package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Sold;

@Repository
public class SoldDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Sold> getListOfSoldByManagerId(int managerid) {
		return em.createQuery(
				"from Sold where managerid = '" + managerid + "' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Sold> getListOfAllSold() {
		return em.createQuery("from Sold order by id desc").getResultList();
	}
	
	@Transactional
	public void persist(Sold sold) {
		Sold transaction = em.merge(sold);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void deleteSold(int id) {
		Sold sold = (Sold) em.find(Sold.class, id);
		Sold transaction = em.merge(sold);
		em.remove(transaction);
		em.close();
	}

}
