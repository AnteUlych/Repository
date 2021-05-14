package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.DirectionDAO;
import box.model.Direction;

@Service("DirectionService")
@Transactional
public class DirectionService {
	
	@Autowired
	private DirectionDAO dao;
	
	public List<Direction> getListOfDirectionsByOblastAndClientid(int clientId, String oblast) {
		return dao.getListOfDirectionsByOblastAndClientid(clientId, oblast);
	}
	
	public boolean isClientHasOblastFromByDirection(int clientId, String oblast){
		List <Direction> directions = dao.getListOfDirectionsByOblastAndClientid(clientId, oblast);	
		if(directions.size()==0){
			return false;
			}else{
				return true;	
		}
	}
	
	public List<Direction> getListOfDirectionsByClientId(int clientId){
		return dao.getListOfDirectionsByClientId(clientId);
	}
	
	public void deleteDirection(int id) {
		dao.deleteDirection(id);
	}
	
	public void addDirection(Direction direction) {
		dao.persist(direction);
	}
	
	

}
