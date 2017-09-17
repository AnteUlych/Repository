package bird.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bird.dao.ReviewDAO;
import bird.model.Review;

@Service("ReviewService")
@Transactional
public class ReviewService {
	
	@Autowired
	private ReviewDAO dao;
	
	public List<Review> getAllReviews() {
		return dao.getAllReviews();
	}
	
	public void addReview(int cargoId, String comment, int rate){
		Review review = new Review();
		
		review.setCargoId(cargoId);
		review.setComment(comment);
		review.setRate(rate);
		review.setTime(new Date());
		
		dao.persist(review);
	}
	
	public void editReview(int id, String comment, int rate) {
		dao.editReview(id, comment, rate);
	}
	
	public void deleteReview(int id) {
		dao.deleteReview(id);
	}
	
	public List<Review> getAllReviewsByCompany(int cargoId) {
		return dao.getAllReviewsByCompany(cargoId);
	}
	
	public int getCountByRate(int rate) {
		return dao.getCountByRate(rate);	
	}

}
