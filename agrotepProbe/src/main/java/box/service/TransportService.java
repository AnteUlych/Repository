package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.TransportDAO;
import box.model.Transport;


@Service("TransportService")
@Transactional
public class TransportService {
	
	@Autowired
	private TransportDAO dao;
	
	public void addTransport(Transport transport){
		dao.persist(transport);
	}
	
	public List<Transport> getAllTransportByDirection(String direction) {
		return dao.getAllTransportByDirection(direction);
	}
	
	public void setTransportStatus(int id, String status) {
		dao.setTransportStatus(id, status);
	}
	
	public void setTransportTruckdriver(int id, String truckdriver) {
		dao.setTransportTruckdriver(id, truckdriver);
	}
	
	public Transport getTransportById(int id) {
		return dao.getTransportById(id);
	}

}
