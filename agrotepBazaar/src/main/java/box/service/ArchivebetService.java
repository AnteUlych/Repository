package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.ArchivebetDAO;
import box.model.Archivebet;



@Service("ArchivebetService")
@Transactional
public class ArchivebetService {
	
	@Autowired
	private ArchivebetDAO dao;
	
	public int getSummOfArchivebetByManagerIdAndStatusDates(String start, String ending, int managerid, String status, String currency) {
		List<Archivebet> bets = dao.getListOfArchivebetByManagerIdAndStatusDates(start, ending, managerid, status);
		int sum = 0;
		
		for(Archivebet b:bets){
			if(b.getCurrency().equals(currency)){
				sum = sum + b.getDifferance();
			}
		}
		
		return sum;
	}
	
	
	public int getNumberOfArchivebetByManagerIdDates(String start, String ending, int managerid) {
		return dao.getListOfArchivebetByManagerIdDates(start, ending, managerid).size();
	}
	
	public int getNumberOfArchivebetByManagerIdAndStatusDates(String start, String ending, int managerid, String status) {
		return dao.getListOfArchivebetByManagerIdAndStatusDates(start, ending, managerid, status).size();
	}
	
	public List<Archivebet> getListOfArchivebetByManagerIdDates(String start, String ending, int managerid) {
		return dao.getListOfArchivebetByManagerIdDates(start, ending, managerid);
	}
	
	public List<Archivebet> getListOfArchivebetByManagerIdAndStatusDates(String start, String ending, int managerid, String status) {
		return dao.getListOfArchivebetByManagerIdAndStatusDates(start, ending, managerid, status);
	}
	
	public void addArchivebet(Archivebet archivebet) {
		dao.persist(archivebet);
	}
	
	public void editArchivebetById(int id, String status) {
		dao.editArchivebetById(id, status);
	}

	public Archivebet getArchivebetByBetid(int betid) {
		return dao.getArchivebetByBetid(betid);
	}
	
	public List<Archivebet> getListOfArchivebetsByAuctionId(int auctionid) {
		return dao.getListOfArchivebetsByAuctionId(auctionid);
	}

}
