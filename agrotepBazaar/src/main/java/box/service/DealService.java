package box.service;

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

}
