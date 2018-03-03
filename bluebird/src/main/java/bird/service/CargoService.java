package bird.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bird.dao.CargoDAO;
import bird.model.Cargo;

@Service("CargoService")
@Transactional
public class CargoService {

	int twoWeeks = 14;
	
	@Autowired
	private CargoDAO dao;

	public List<Cargo> getAllActiveCargo() {
		return dao.getAllActiveCargo();
	}

	public Cargo getCargoBy(int id) {
		return dao.getCargoBy(id);
	}

	public List<Cargo> getAllCargoByClient(String client) {
		return dao.getAllCargoByClient(client);
	}

	public int getCountCargosByClient(String client) {
		List<Cargo> cargos = dao.getAllCargoByClient(client);
		return cargos.size();
	}

	public List<Cargo> getAllActiveCargosByClient(String client) {
		return dao.getAllActiveCargosByClient(client);
	}

	public void editCargo(int id, String client, String description, int active) {
		dao.editCargo(id, client, description, active);
	}
	
	public void editDeliveryDateForCargo(int id, String deliveryDate) {
		try {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date delivery = format.parse(deliveryDate);
		dao.editDeliveryDateForCargo(id, delivery);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dao.editCargo(id, client, description, active);
	}
	
	public void finishCargo(int id) {
		dao.finishCargo(id);
	}

	public void deleteCargo(int id) {
		dao.deleteCargo(id);
	}

	public void addCargo(String client, String description) {

		Cargo cargo = new Cargo();

		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);            
		calendar.add(Calendar.DAY_OF_YEAR, twoWeeks);
		Date ETD = calendar.getTime();
		
		cargo.setActive(1);
		cargo.setDelivery(ETD);
		cargo.setClient(client);
		cargo.setDescription(description);

		dao.persist(cargo);
	}
}
