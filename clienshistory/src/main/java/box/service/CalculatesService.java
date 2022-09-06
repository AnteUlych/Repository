package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import box.dao.CalculatesDAO;
import box.model.Calculates;

public class CalculatesService {

	@Autowired
	private CalculatesDAO dao;

	// test
	public List<Calculates> getListOfCalculates() {
		return dao.getListOfCalculates();
	}

	public List<Calculates> getListOfCalculatesFromDate(String startDate) {
		return dao.getListOfCalculatesFromDate(startDate);
	}

	public List<Calculates> getListOfCalculatesFromDateByManagerId(
			String startDate, int managerid) {
		return dao.getListOfCalculatesFromDateByManagerId(startDate, managerid);
	}

	public void addCalculates(Calculates calculates) {
		dao.persist(calculates);
	}
	
	public Calculates getCalculatesById(int id){
		return dao.getCalculatesById(id);
	}

	public void editCalculatesById(int id, String budget, String cityfrom,
			String cityto, String comments, String company, int companyid,
			String countryfrom, String countryto, String customsfrom,
			String customsto, int dangerous, String calculateonadate,
			String exportimport, String freight, String rate,
			String temperature, String truck, int weight) {
		dao.editCalculatesById(id, budget, cityfrom, cityto, comments, company,
				companyid, countryfrom, countryto, customsfrom, customsto,
				dangerous, calculateonadate, exportimport, freight, rate,
				temperature, truck, weight);
	}

}
