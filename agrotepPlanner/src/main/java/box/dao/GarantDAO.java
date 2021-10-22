package box.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Garant;

@Repository
public class GarantDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Garant> getListOfGarants(){
		return em.createQuery("from Garant order by client").getResultList();
	}
	
	@Transactional
	public void persist(Garant garant){
		Garant transaction = em.merge(garant);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void deleteGarantById(int id) {
		Garant garant = (Garant)em.find(Garant.class, id);
		Garant transaction = em.merge(garant);
		em.remove(transaction);
		em.close();
	}
	
	@Transactional
	public void editGarantById(int id, String truckandmanager, String color, Date plandate) {
		Garant garant = (Garant)em.find(Garant.class, id);
		
		garant.setTruckandmanager(truckandmanager);
		garant.setColor(color);
		garant.setColor(color);
		
		Garant transaction = em.merge(garant);
		em.persist(transaction);
		em.close();
	}
	
	public Garant getGarantById(int id){
		Garant garant = (Garant)em.find(Garant.class, id);		
		return garant;
	}

}
