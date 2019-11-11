package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Archiveauction;

@Repository
public class ArchiveauctionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Archiveauction archiveauction) {
		Archiveauction transaction = em.merge(archiveauction);
		em.persist(transaction);
		em.close();
	}
	
	public Archiveauction getArchiveauctionByAuctionId(int auctionid){
		Query query = em
				.createQuery("from Archiveauction where auctionid = '" + auctionid + "'");
		return (Archiveauction) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Archiveauction> getListOfArchiveauctionDates(String start, String ending) {
		return em.createQuery(
				"from Archiveauction where date >= '" + start+"' and date <= '"+ ending+"' order by id")
				.getResultList();
	}

}
