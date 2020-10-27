package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

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

}
