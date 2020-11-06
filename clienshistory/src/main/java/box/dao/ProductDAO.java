package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.logic.Constants;
import box.model.Product;

@Repository
public class ProductDAO {
	
	Constants constant = new Constants();
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Product> getListOfOpenProducts() {
		return em.createQuery(
				"from Product where status ='"+constant.PRODUCT_STATUS_OPEN+"'").getResultList();
	}
	
	public Product getProductById(int productid){
		Product product = (Product) em.find(Product.class, productid);
		return product;
	}
	
	@Transactional
	public void persist(Product product) {
		Product transaction = em.merge(product);
		em.persist(transaction);
		em.close();
	}
	
	public void hideProduct(int id){
		
		Product product = (Product) em.find(Product.class, id);
		product.setStatus(constant.PRODUCT_STATUS_HIDE);
		
		Product transaction = em.merge(product);
		em.persist(transaction);
		em.close();
	}
	
   public void openProduct(int id){
		
		Product product = (Product) em.find(Product.class, id);
		product.setStatus(constant.PRODUCT_STATUS_OPEN);
		
		Product transaction = em.merge(product);
		em.persist(transaction);
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getListOfProducts() {
		return em.createQuery(
				"from Product order by product").getResultList();
	}

}
