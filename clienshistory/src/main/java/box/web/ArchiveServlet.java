package box.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Calculates;
import box.model.Product;

@Controller
@RequestMapping("/archive")
public class ArchiveServlet {
	
	Constants constant = new Constants();

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		int rank = (Integer) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");

		DataBaseController base = new DataBaseController();

		String menuForHead = "";

		if (rank == constant.MANAGER_RANK_MANAGER) {

		} else {
			menuForHead = constant.MENU_FOR_HEAD;
		}

		List<Product> products = base.getListOfOpenProducts();
		
		List<Calculates> calculates = new ArrayList();
		
		if(rank==0){
			calculates = base.getListOfCalculatesByManagerid(id);
		}else{
			calculates = base.getListOfCalculates();
		}
		
		base.closeConnection();

		model.addAttribute("name", name);
		model.addAttribute("products", products);
		model.addAttribute("menuForHead", menuForHead);
		
		model.addAttribute("calculates", calculates);
			
		return "archive";
	}

}
