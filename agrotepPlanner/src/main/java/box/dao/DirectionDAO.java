package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Direction;


@Repository
public class DirectionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Direction> getListOfDirectionsByOblastAndClientid(int clientId, String oblast) {
		return em.createQuery("from Direction where oblastFrom='"+oblast+"' and clientId='"+clientId+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public boolean isClientNotWorkByOblastFromAndOblastTo(String oblastFrom, String oblastTo, int clientId) {
		return em.createQuery("from Direction where oblastFrom='"+oblastFrom+"' and oblastTo='"+oblastTo+"' and clientId='"+clientId+"'").getResultList().isEmpty();
	}
	
	@SuppressWarnings("unchecked")
	public List<Direction> getListOfDirectionsByClientId(int clientId){
		return em.createQuery("from Direction where clientId='"+clientId+"'").getResultList();
	}
	
	@Transactional
	public void persist(Direction direction) {
		Direction transaction = em.merge(direction);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void deleteDirection(int id) {
		Direction direction = (Direction) em.find(Direction.class, id);
		Direction transaction = em.merge(direction);
		em.remove(transaction);
		em.close();
	}

}
