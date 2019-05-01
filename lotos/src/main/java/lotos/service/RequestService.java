package lotos.service;

import java.util.List;

import lotos.dao.RequestDAO;
import lotos.model.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("RequestService")
@Transactional
public class RequestService {

	@Autowired
	private RequestDAO dao;

	public void createNewRequest(Request request) {
		dao.persist(request);
	}
	
	public boolean isMailInRequestExist(String mail) {
		try {
			dao.getRequestByMail(mail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isCodeInRequestExist(String code) {
		try {
			dao.getRequestByCode(code);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
