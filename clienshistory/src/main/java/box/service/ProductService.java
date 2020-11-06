package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.ProductDAO;
import box.model.Product;

@Service("ProductService")
@Transactional
public class ProductService {
	
	@Autowired
	private ProductDAO dao;
	
	public List<Product> getListOfOpenProducts() {
		return dao.getListOfOpenProducts();
	}
	
	public Product getProductById(int productid){
		return dao.getProductById(productid);
	}
	
	public void addProduct(Product product){
		dao.persist(product);
	}
	
	public void hideProduct(int id){
		dao.hideProduct(id);
	}
	
	 public void openProduct(int id){
		 dao.openProduct(id);
	 }
	
	public List<Product> getListOfProducts() {
		return dao.getListOfProducts();
	}
	
	public boolean isProductsExis(String product) {
		List<Product> ps = dao.getListOfProducts();
		
		for(Product p:ps){
			if(p.getProduct().equals(product)){
				return true;
			}
		}
		
		return false;
	}


}
