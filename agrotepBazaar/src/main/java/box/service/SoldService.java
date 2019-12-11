package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.SoldDAO;
import box.model.Sold;

@Service("SoldService")
@Transactional
public class SoldService {
	
	@Autowired
	private SoldDAO dao;
	
	public List<Sold> getListOfSoldByManagerId(int managerid) {
		return dao.getListOfSoldByManagerId(managerid);
	}
	
	public List<Sold> getListOfAllSold() {
		return dao.getListOfAllSold();
	}
	
	public int getNumberOfSoldByManagerId(int managerid) {
		return dao.getListOfSoldByManagerId(managerid).size();
	}
	
	public void addSold(Sold sold) {
		dao.persist(sold);
	}
	
	public void deleteSold(int id) {
		dao.deleteSold(id);
	}
	
	public List<Sold> getListOfSoldAuctionId(int auctionid) {
		return dao.getListOfSoldAuctionId(auctionid);
	}

}
