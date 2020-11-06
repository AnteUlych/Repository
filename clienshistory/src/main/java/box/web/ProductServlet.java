package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Product;

@Controller
@RequestMapping("/products")
public class ProductServlet {
	
	Constants constant = new Constants();
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		

		 HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		 if(rank != constant.MANAGER_RANK_MANAGER){
		 DataBaseController base = new DataBaseController();
		 
		 String messagealert = "";
		 String menuForHead = "";
		 String addProduct = "";
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){

		 }else{
			 addProduct = "<button class=\"w3-button \" onclick=\"document.getElementById('add').style.display='block'\"><i class=\"fa fa-plus\"> </i></button>";
			 menuForHead = constant.MENU_FOR_HEAD;
		 }
		
		 List<Product> products = base.getListOfOpenProducts();
		 List<Product> allProducts = base.getListOfProducts();
		 
		 List<String> productButtons = new ArrayList();
		 
		 for(Product p:allProducts){
			 if(p.getStatus()==constant.PRODUCT_STATUS_OPEN){
				 productButtons.add("<button type=\"submit\" novalidate class=\"w3-button w3-quarter  w3-green w3-round-xxlarge\" name=\""+p.getId()+"\"+value=\""+p.getId()+"\">"+p.getProduct()+"</button>");
			 }else{
				 productButtons.add("<button type=\"submit\" novalidate class=\"w3-button w3-quarter w3-white w3-border w3-border-red  w3-round-xxlarge\" name=\""+p.getId()+"\"+value=\""+p.getId()+"\">"+p.getProduct()+"</button>");
			 }
		 }
		
		 
		 base.closeConnection();
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 model.addAttribute("messagealert", messagealert);
		 model.addAttribute("allProducts", allProducts);
		 model.addAttribute("productButtons", productButtons);
		 
		 model.addAttribute("addProduct", addProduct);
		 
		 }
		return "products";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		 DataBaseController base = new DataBaseController();
		 
		 String messagealert = "";
		 String menuForHead = "";
		 String addProduct = "";
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){

		 }else{
			 addProduct = "<button class=\"w3-button \" onclick=\"document.getElementById('add').style.display='block'\"><i class=\"fa fa-plus\"> </i></button>";
			 menuForHead = constant.MENU_FOR_HEAD;
		 }
		
		 List<Product> products = base.getListOfOpenProducts();
	
		 if(request.getParameter("addproduct")!=null){
		 
		 String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String newProduct = request.getParameter("newProduct");
			
			if (newProduct != null){
				try {
					newProduct = new String(newProduct.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if(base.isProductsExis(newProduct)){
				messagealert = "alert(\""+"Продукт  "+newProduct+" вже існує в системі!"+"\");";
			}else{
			
			Product prod = new Product();
			
			prod.setProduct(newProduct);
			prod.setStatus(constant.PRODUCT_STATUS_OPEN);
			
			base.addProduct(prod);
			
			}
			
			
		 }
		 
		 
			
			 List<Product> allProducts = base.getListOfProducts();
			 
			 for(Product pr:allProducts){
				 if(request.getParameter(pr.getId()+"")!=null){
					 if(pr.getStatus()==constant.PRODUCT_STATUS_OPEN){
						 base.hideProduct(pr.getId());
					 }
					 if(pr.getStatus()==constant.PRODUCT_STATUS_HIDE){
						 base.openProduct(pr.getId());
					 }
				 }
			 }
			 
			 allProducts = base.getListOfProducts();
			 List<String> productButtons = new ArrayList();
			 
			 for(Product p:allProducts){
				 if(p.getStatus()==constant.PRODUCT_STATUS_OPEN){
					 productButtons.add("<button type=\"submit\" novalidate class=\"w3-button w3-quarter  w3-green w3-round-xxlarge\" name=\""+p.getId()+"\"+value=\""+p.getId()+"\">"+p.getProduct()+"</button>");
				 }else{
					 productButtons.add("<button type=\"submit\" novalidate class=\"w3-button w3-quarter w3-white w3-border w3-border-red  w3-round-xxlarge\" name=\""+p.getId()+"\"+value=\""+p.getId()+"\">"+p.getProduct()+"</button>");
				 }
			 }
		
		
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 model.addAttribute("messagealert", messagealert);
		 model.addAttribute("allProducts", allProducts);
		 model.addAttribute("productButtons", productButtons);
		 
		 model.addAttribute("addProduct", addProduct);
		 
		 
		 base.closeConnection();
		 
		 try {
				response.sendRedirect("/clientshisory/products");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		 return "products";
	}

}
