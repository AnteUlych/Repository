package bird.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bird.model.Review;

@Repository
public class ReviewDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void persist(Review review) {
		Review transaction = em.merge(review);
		em.persist(transaction);
		em.close();
	}

	@Transactional
	public void editReview(int id, String comment, int rate) {

		Review review = (Review) em.find(Review.class, id);

		review.setComment(comment);
		review.setRate(rate);
		review.setTime(new Date());

		Review transaction = em.merge(review);
		em.persist(transaction);
		em.close();
	}

	@Transactional
	public void deleteReview(int id) {
		Review review = (Review) em.find(Review.class, id);
		Review transaction = em.merge(review);
		em.remove(transaction);
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Review> getAllReviewsByCompany(int cargoId) {

		return em.createQuery(
				"from Review where cargoId = '" + cargoId
						+ "' order by id desc").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Review> getAllReviews() {

		return em.createQuery("from Review order by id desc").getResultList();
	}

	public int getCountByRate(int rate) {

		Query query = em
				.createQuery("SELECT COUNT(c) FROM Review c where rate ='"
						+ rate + "'");

		long result = (Long) query.getSingleResult();
		return Math.toIntExact(result);
	}

}
