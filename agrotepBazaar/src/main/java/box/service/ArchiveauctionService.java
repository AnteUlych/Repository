package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.ArchiveauctionDAO;
import box.model.Archiveauction;

@Service("ArchiveauctionService")
@Transactional
public class ArchiveauctionService {
	
	@Autowired
	private ArchiveauctionDAO dao;
	
	public Archiveauction getArchiveauctionByAuctionId(int auctionid){
		return dao.getArchiveauctionByAuctionId(auctionid);
	}
	
	public void addArchiveauction(Archiveauction archiveauction) {
		dao.persist(archiveauction);
	}

	public int getNumberOfArchiveauctionDates(String start, String ending) {
		return dao.getListOfArchiveauctionDates(start, ending).size();
	}
	
	public List<Archiveauction> getListOfArchiveauctionDates(String start, String ending) {
		return dao.getListOfArchiveauctionDates(start, ending);
	}
}
