package box.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.GarantDAO;
import box.model.Garant;

@Service("GarantService")
@Transactional
public class GarantService {
	
	@Autowired
	private GarantDAO dao;
	
	public List<Garant> getListOfGarants(){
		return dao.getListOfGarants();
	}
	
	public void addGarant(Garant garant){
		dao.persist(garant);
	}
	
	public void deleteGarantById(int id) {
		dao.deleteGarantById(id);
	}
	
	public void editGarantById(int id, String truckandmanager, String color, Date plandate) {
		dao.editGarantById(id, truckandmanager, color, plandate);
	}
	
	public Garant getGarantById(int id){
		return dao.getGarantById(id);
	}

}
