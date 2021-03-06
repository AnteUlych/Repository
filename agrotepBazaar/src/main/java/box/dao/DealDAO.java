package box.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Deal;


@Repository
public class DealDAO {
	
	// max result of requests 1500
	public int max = 1500;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Deal deal) {
		Deal transaction = em.merge(deal);
		em.persist(transaction);
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Deal> getListOfallDeals() {					
		return em.createQuery(
				"from Deal order by dateoftransportation desc")
				.setMaxResults(max).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Deal> getListOfallDealsByDirection(String direction) {					
		return em.createQuery(
				"from Deal where direction = '" + direction + "' order by dateoftransportation desc")
				.setMaxResults(max).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Deal> getListOfDealsBetweenDates(String dateStart, String dateFinish) {					
		return em.createQuery(
				"from Deal where dateoftransportation  >= '" + dateStart+"' and dateoftransportation <= '"+ dateFinish+"' order by dateoftransportation desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Deal> getListOfDealsBetweenDatesAndManagerId(String dateStart, String dateFinish, int managerid) {					
		return em.createQuery(
				"from Deal where dateoftransportation  >= '" + dateStart+"' and dateoftransportation <= '"+ dateFinish+"' and managerid ='"+managerid+"' order by dateoftransportation desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Deal> getListOfTodayDealsByManagerId(String today, int managerid) {					
		return em.createQuery(
				"from Deal where date  >= '" + today+"' and managerid ='"+managerid+"'")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Deal> getListOfallDealsByManagerId(int managerid) {					
		return em.createQuery(
				"from Deal where managerid = '" + managerid + "' order by dateoftransportation desc")
				.setMaxResults(max).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Deal> getListOfallDealsByManagerIdAndDirection(int managerid, String direction) {					
		return em.createQuery(
				"from Deal where managerid = '" + managerid + "' and direction = '" + direction + "' order by dateoftransportation desc")
				.setMaxResults(max).getResultList();
	}
	
	public Deal getDealById(int id) {
		Query query = em
				.createQuery("from Deal where id = '" + id + "'");
		return (Deal) query.getSingleResult();
	}
	
	@Transactional
	public void editTruckdriverById(int id, String truckdriver) {

		Deal deal = (Deal) em.find(Deal.class, id);

		deal.setTruckdriver(truckdriver);

		Deal transaction = em.merge(deal);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void editStatusOfDealById(int id, String status) {

		Deal deal = (Deal) em.find(Deal.class, id);

		deal.setStatus(status);

		Deal transaction = em.merge(deal);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void editDateoftransportationOfDealById(int id, Date date) {

		Deal deal = (Deal) em.find(Deal.class, id);

		deal.setDateoftransportation(date);

		Deal transaction = em.merge(deal);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void editOtherinformationOfDealById(int id, String otherinformation) {

		Deal deal = (Deal) em.find(Deal.class, id);

		deal.setOtherinformation(otherinformation);

		Deal transaction = em.merge(deal);
		em.persist(transaction);
		em.close();
	}
	
	//"from Auction where direction = '" + direction + "' order by importance"

}
