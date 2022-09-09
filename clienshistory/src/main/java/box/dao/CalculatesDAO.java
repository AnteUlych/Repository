package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import box.model.Calculates;

public class CalculatesDAO {

	@PersistenceContext
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public List<Calculates> getListOfCalculates() {
		return em.createQuery("from Calculates order by id desc").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Calculates> getListOfCalculatesByManagerid(int managerid) {
		return em.createQuery("from Calculates where managerid='" + managerid
						+ "' order by id desc").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Calculates> getListOfCalculatesFromDate(String startDate) {
		return em.createQuery(
				"from Calculates where dateofcalculate >=' " + startDate
						+ "' order by id desc").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Calculates> getListOfCalculatesFromDateByManagerId(
			String startDate, int managerid) {
		return em.createQuery(
				"from Calculates where managerid='" + managerid
						+ "' and dateofcalculate >=' " + startDate
						+ "' order by id desc").getResultList();
	}

	@Transactional
	public void persist(Calculates calculates) {
		Calculates transaction = em.merge(calculates);
		em.persist(transaction);
		em.close();
	}
	
	public Calculates getCalculatesById(int id){
		Calculates calculates = (Calculates) em.find(Calculates.class, id);
		return calculates;
	}
	
	
	@Transactional
	public void editCalculatesById(int id, String budget, String cityfrom,
			String cityto, String comments, String company, int companyid,
			String countryfrom, String countryto,
			String dangerous, String calculateonadate,
			String exportimport, String freight, String rate,
			String temperature, String truck, int weight) {

		Calculates calculates = (Calculates) em.find(Calculates.class, id);

		calculates.setBudget(budget);
		calculates.setCityfrom(cityfrom);
		calculates.setCityto(cityto);
		calculates.setComments(comments);
		calculates.setCompany(company);
		calculates.setCompanyid(companyid);
		calculates.setCountryfrom(countryfrom);
		calculates.setCountryto(countryto);
		calculates.setDangerous(dangerous);
		calculates.setCalculateonadate(calculateonadate);
		calculates.setExportimport(exportimport);
		calculates.setFreight(freight);
		calculates.setRate(rate);
		calculates.setTemperature(temperature);
		calculates.setTruck(truck);
		calculates.setWeight(weight);

		Calculates transaction = em.merge(calculates);
		em.persist(transaction);
		em.close();
	}

}
