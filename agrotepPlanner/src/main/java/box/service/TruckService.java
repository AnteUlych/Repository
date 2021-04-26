package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.TruckDAO;
import box.model.Truck;



@Service("TruckService")
@Transactional
public class TruckService {
	
	@Autowired
	private TruckDAO dao;
	
	public List<Truck> getListOfTrucks() {
		return dao.getListOfTrucks();
	}

}
