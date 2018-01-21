package bird.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bird.dao.AccessDAO;
import bird.model.Access;


@Service("AccessService")
@Transactional
public class AccessService {

	@Autowired
	private AccessDAO dao;
	
	public List<Access> getAllAccess() {
		return dao.getAllAccess();
	}
}
