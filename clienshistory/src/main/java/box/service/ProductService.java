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


}
