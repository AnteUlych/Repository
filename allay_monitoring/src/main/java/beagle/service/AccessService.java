package beagle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beagle.dao.AccessDAO;
import beagle.model.Access;

@Service("AccessService")
public class AccessService {

	@Autowired
	private AccessDAO dao;

	public boolean getAccessConfirmation(String requestIp) {

		List<Access> access = dao.getAccessList();

		for (Access code : access) {
			if (code.getIp().equals(requestIp)) {
				return true;
			}
		}

		return false;
	}

}
