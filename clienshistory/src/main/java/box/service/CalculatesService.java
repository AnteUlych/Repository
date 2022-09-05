package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import box.dao.CalculatesDAO;
import box.model.Calculates;

public class CalculatesService {
	
	@Autowired
	private CalculatesDAO dao;
	//test
	public List<Calculates> getListOfCalculates(){
		return dao.getListOfCalculates();
	}

}
