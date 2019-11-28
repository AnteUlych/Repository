package box.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.DealDAO;
import box.model.Deal;

@Service("BetService")
@Transactional
public class DealService {
	
	@Autowired
	private DealDAO dao;
	
	public void addDeal(Deal deal){
		dao.persist(deal);
	}
	
	public List<Deal> getListOfallDeals() {
		return dao.getListOfallDeals();
	}
	
	public List<Deal> getListOfallDealsByDirection(String direction) {
		return dao.getListOfallDealsByDirection(direction);
	}
	
	public List<Deal> getListOfallDealsByManagerId(int managerid) {	
		return dao.getListOfallDealsByManagerId(managerid);
	}
	
	public List<Deal> getListOfallDealsByManagerIdAndDirection(int managerid, String direction) {
		return dao.getListOfallDealsByManagerIdAndDirection(managerid, direction);
	}
	
	public Deal getDealById(int id) {
		return dao.getDealById(id);
	}
	
	public void editTruckdriverById(int id, String truckdriver) {
		dao.editTruckdriverById(id, truckdriver);
	}

	public void editStatusOfDealById(int id, String status) {
		dao.editStatusOfDealById(id, status);
	}
	
	public void editOtherinformationOfDealById(int id, String otherinformation) {
		dao.editOtherinformationOfDealById(id, otherinformation);
	}
	
	public void editDateoftransportationOfDealById(int id, Date date) {
		dao.editDateoftransportationOfDealById(id, date);
	}

}
